class Solution {
     public String solution(String new_id) {
        // step1
        new_id = new_id.toLowerCase();
        // step2
        new_id=new_id.replaceAll("[^\\w\\-_.]*", "");
        System.out.println(new_id);
        // step3
        new_id = new_id.replaceAll("[.]{2,}", ".");
        System.out.println(new_id);
        // step4
        new_id=new_id.replaceAll("^[.]|[.]$", "");
        // step5
        if (new_id.length() == 0) new_id = "a";
        // step6
        if (new_id.length() >= 16) new_id = new_id.substring(0, 15);
        new_id=new_id.replaceAll("^[.]|[.]$", "");
        // step7
        char lc = new_id.charAt(new_id.length() - 1);
        while (new_id.length() < 3) {
            new_id += lc;
        }
        return new_id;
    }
}