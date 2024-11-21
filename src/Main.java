//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Node<Integer> listNums = new Node<>(12, new Node<>(32,
                new Node<>(3, new Node<>(32,
                        new Node<>(2, new Node<>(32))))));
        Node<Integer> list2 = new Node<>(32);
        System.out.println(howManyTimesX(null, 32));

    }


    //example A: lst - 1->2->3->X->5   val-4
    //example B: lst - null , val - 0
    //example C: lst-> 3->6->7->9  , val -1
    public static Node<Integer> insertToList(Node<Integer> lst, int val) {
        Node<Integer> tmpL = lst;
        Node<Integer> nd = new Node<>(val);
        if (lst == null)   //lst is empty
            return nd;
        if (lst.getValue() > val) {
            nd.setNext(lst);
            return nd;
        }
        //tmpL-> 3->6->7->9
        //      nxtTmp->6->7->9
        Node<Integer> nxtTmp = tmpL.getNext();
        while (nxtTmp != null) {
            if (tmpL.getValue() < val && val < nxtTmp.getValue()) {
                nd.setNext(nxtTmp);
                tmpL.setNext(nd);
               return lst;
            }
            tmpL = nxtTmp;
            nxtTmp = nxtTmp.getNext();
        }
        return lst;

    }


    //lst-> 12-> 32-> 3-> 32-> 2-> 32 ->  null
    // x-32
    public static int howManyTimesX(Node<Integer> lst, int x) {
        Node<Integer> tmpL = lst;
        int countX = 0;
        while (tmpL != null) {
            if (tmpL.getValue() == x) {
                countX++;
            }
            tmpL = tmpL.getNext();
        }
        return countX;
    }


}