package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yeison Melo <melo.yeison@gmail.com>
 */
public class Permutation {

    private static List<String> permutationRecursive(String permutation, List<String> elements) {

        List<String> r = new ArrayList();
        if (elements.isEmpty()) {
            r.add(permutation);
        } else {
            for (int i = 0; i < elements.size(); i++) {
                String auxDigit = elements.get(i);
                elements.remove(i);
                r.addAll(permutationRecursive(permutation.concat(auxDigit), elements));
                elements.add(i, auxDigit);
            }
        }
        return r;
    }

    private static List<String> getPermutations(String arg) {
        String[] split = arg.split(" ");
        List<String> list = new ArrayList();

        for (int i = 0; i < split.length; ++i) {
            list.add(split[i]);
        }

        return permutationRecursive("", list);
    }

    /**
     * @param args the command line arguments
     * @return 
     */
    public static List<String> main(String[] args) {

        List<String> result = getPermutations(args[0]);
        System.out.println(result);
        return result;
    }
}
