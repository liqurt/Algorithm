package View;

import java.io.*;

public class View {
    public void gogogo() {
        final String inputFilePath = "./src/View/input.txt";
        final File inputFile = new File(inputFilePath);
        final int UNABLE_BUILDING_AREA = 2;
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String str;
            try{
                boolean isLength = true;
                int testCaseLength = -1;
                int testCase = 0;
                while((str = in.readLine()) != null){
                    if(isLength){
                        testCaseLength = Integer.parseInt(str);
                    }else{
                        //입력 관련 잡다구리
                        String[] temp = str.split(" ");
                        int[] buildings = new int[testCaseLength];
                        for (int i=0 ; i<testCaseLength ; i++){
                            buildings[i] = Integer.parseInt(temp[i]);
                        }
                        int l2;
                        int l1;
                        int me;
                        int r1;
                        int r2;
                        int sum=0;
                        for (int i=UNABLE_BUILDING_AREA ; i < testCaseLength - UNABLE_BUILDING_AREA ; i++){
                            l2 = buildings[i-2];
                            l1 = buildings[i-1];
                            me = buildings[i];
                            r1 = buildings[i+1];
                            r2 = buildings[i+2];
                            if((l2<me && l1<me) && (me>r1 && me>r2)){
                                sum+=(me - Math.max(Math.max(l2,l1),Math.max(r1,r2)));
                            }
                        }
                        System.out.println("#"+(testCase+1)+" "+sum);
                        testCase++;
                    }
                    isLength = !isLength;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}