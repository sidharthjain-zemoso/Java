package Assignment6;

import java.util.Vector;

public class Vampire {
    Vector<String> permutations;

    void swap(StringBuilder str, int i, int j){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    void permutate(StringBuilder str, int l, int r){
        if(l==r){
//            System.out.print(str+" ");
            permutations.add(str.toString());
        }else{
            for (int i = l; i <= r; i++) {
                swap(str, l, i);
                permutate(str, l+1, r);
                swap(str, l, i);
            }
        }
    }

    boolean isVampire(int v){
        permutations = new Vector<>();
        String vStr = String.valueOf(v);
        this.permutate(new StringBuilder(vStr), 0, vStr.length()-1);
        int len = vStr.length();
//        if(vStr.length()%2!=0) return false;
//        System.out.println(permutations);
        for(String perm: permutations){
            String xStr = perm.substring(0, len/2);
            String yStr = perm.substring(len/2, len);
            if(xStr.charAt(xStr.length()-1)=='0' && yStr.charAt(yStr.length()-1)=='0') continue;
            int x = Integer.parseInt(xStr);
            int y = Integer.parseInt(yStr);
            if(x*y==v) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Vampire vampire = new Vampire();
        int count = 0;
        int i = 1254;
        while(count<100){
            if(vampire.isVampire(i)){
                if(count%10==0) {
                    System.out.println();
                    System.out.print((count/10+1)+": ");
                }
                System.out.print(i+" ");
                count++;
            }
            i++;
            if(((int)Math.log10(i)+1)%2!=0){
                i = i*10;
            }
        }
    }
}
