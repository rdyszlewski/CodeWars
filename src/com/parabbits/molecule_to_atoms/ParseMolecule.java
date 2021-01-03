package com.parabbits.molecule_to_atoms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
For a given chemical formula represented by a string, count the number of atoms of each element contained in the molecule and return an object (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

For example:

String water = "H2O";
parseMolecule.getAtoms(water); // return [H: 2, O: 1]

String magnesiumHydroxide = "Mg(OH)2";
parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

String fremySalt = "K4[ON(SO3)2]2";
parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException

As you can see, some formulas have brackets in them. The index outside the brackets tells you that you have to multiply count of each atom inside the bracket on this index. For example, in Fe(NO3)2 you have one iron atom, two nitrogen atoms and six oxygen atoms.

Note that brackets may be round, square or curly and can also be nested. Index after the braces is optional.

 */
public class ParseMolecule {
    public static Pattern squareBracketPattern;
    public static Pattern roundBracketPattern;
    public static Pattern formulaPattern;

    public static Pattern pattern;
    // ([{([]?)([A-Z][a-z]?([0-9])*)([\}\]\)]?)
    static{
        squareBracketPattern = Pattern.compile("\\[(.*)\\]([0-9]*)");
        roundBracketPattern = Pattern.compile("\\(([A-z0-9]*)\\)([0-9]*)");
        formulaPattern = Pattern.compile("([A-Z][a-z]*)([0-9]*)");
//        pattern = Pattern.compile("([{\\(\\[]?)(([A-Z][a-z]*|[\\)\\]\\}]*)([0-9])*)([\\}\\]\\)]?)");
        pattern = Pattern.compile("([\\{(\\[]?)(([A-Z][a-z]*|[\\)\\]\\}]*)([0-9])*)([\\}\\]\\)]?)([0-9]*)");
    }

    public static Map<String,Integer> getAtoms(String formula) {
        Map<String, Integer> resultMap = new HashMap<>();
        // TODO: dokończyć to
        List<SymbolElement> elements = parse(formula);
        return resultMap;
    }

    private static List<SymbolElement> parse(String formula){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        Matcher matcher = pattern.matcher(formula);
        List<SymbolElement> symbols = new ArrayList<>();
        Stack<MultiplierElement> innerSymbols = new Stack<>();
        Stack<MultiplierElement> multiplierElements = new Stack<>();
        int openedBrackets = 0;
        while(matcher.find()){
            if(!matcher.group(1).isEmpty()){
                innerSymbols.add(new MultiplierElement());
                openedBrackets++;
            }
            if(matcher.group(5).isEmpty()){
                if(openedBrackets > 0){
                    int number = matcher.group(4) != null? Integer.parseInt(matcher.group(4)) : 1;
                    innerSymbols.peek().elements.add(new SymbolElement(matcher.group(3), number));
                } else {
                    int number = matcher.group(4) != null? Integer.parseInt(matcher.group(4)) : 1;
                    symbols.add(new SymbolElement(matcher.group(3), number));
                }

            } else {
                // TODO: pobranie i przypisanie
                openedBrackets--;
                MultiplierElement element;
                int number = matcher.group(4) != null? Integer.parseInt(matcher.group(4)) : 1;
                // TODO: jeżeli
                innerSymbols.peek().elements.add(new SymbolElement(matcher.group(3), number));

                element = innerSymbols.pop();
                int elementMultiplier = matcher.group(4) != null? Integer.parseInt(matcher.group(4)) : 1;
                element.multiplier = elementMultiplier;
                multiplierElements.add(element);


                if(innerSymbols.isEmpty()){
                    int multiplier = 1;
                    while(!multiplierElements.isEmpty()){
                        MultiplierElement element1 = multiplierElements.pop();
                        multiplier *= element1.multiplier;
                        for(SymbolElement element2 : element1.elements){
                            element2.number *= multiplier;
                            symbols.add(element2);
                        }
                    }
                }

            }
        }
        return symbols;
    }

    private static class SymbolElement{
        public String symbol;
        public int number;

        public SymbolElement(String symbol, int number){
            this.symbol = symbol;
            this.number = number;
        }
    }

    private static class MultiplierElement{
        public List<SymbolElement> elements = new ArrayList<>();
        public int multiplier = 1;
    }


}
