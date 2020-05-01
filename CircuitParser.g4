parser grammar CircuitParser;
options {tokenVocab=CircuitLexer;}

@header {import circuits.*;}

@members { EquationCircuit circuit = new EquationCircuit();}

prog : prg EOF;

prg : circuit_op commandes;

circuit_op : FCTN LPAR listeport {circuit.setInputs($listeport.listenom);} RPAR RETURN LPAR listeport {circuit.setOutputs($listeport.listenom);} RPAR ensemble_equations ND;

listeport returns [ List<String> listenom ] :
PORT { $listenom=new ArrayList<String>(); $listenom.add($PORT.text); }
| PORT VIRG lsub = listeport { $lsub.listenom.add($PORT.text); $listenom=$lsub.listenom; }
;

ensemble_equations :
equation
| equation ensemble_equations
;

equation : PORT EQU expbool SEMIC {circuit.getOutput($PORT.text).setIn($expbool.comp);};

expbool returns [ Composant comp ] :
LPAR expbool RPAR {$comp = $expbool.comp;}
| INT expbool { Not n=new Not(); n.setIn($expbool.comp); circuit.add(n); $comp=n; }
| e1=expbool ESP e2=expbool { And a=new And(); a.setIn1($e1.comp); a.setIn2($e2.comp); circuit.add(a); $comp=a; }
| e1=expbool BAR e2=expbool { Or o=new Or(); o.setIn1($e1.comp); o.setIn2($e2.comp); circuit.add(o); $comp=o; }
| PORT {$comp = circuit.getInput($PORT.text);}
;

commandes :
commande
| commande commandes
;

commande :
DESC LPAR RPAR {circuit.descr();}
|EVL LPAR liste_etat RPAR {circuit.eval($liste_etat.liste);}
;

liste_etat returns [ List<Boolean> liste ] :
boole VIRG lsub=liste_etat { $lsub.liste.add($boole.b); $liste=$lsub.liste; }
| boole { $liste=new ArrayList<Boolean>(); $liste.add($boole.b); }
;

boole returns[Boolean b]:
    BTRUE{$b=Boolean.TRUE;}|
    BFALSE{$b=Boolean.FALSE;};