package Mode;

import java.io.*;

public class Mode {
    public void gogogo() {
        final String inputFilePath = "./src/Mode/input.txt";
        final File inputFile = new File(inputFilePath);
        final int numberOfStudents = 1000;
        final int maxScore = 100;

        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String str;
            try {
                int T = Integer.parseInt(in.readLine());
                int testCase = 0;
                boolean isTestCase = true;
                while ((str = in.readLine()) != null) {
                    if(isTestCase){
                        //별거없음
                    }else{
                        //입력 관련 잡다구리
                        String[] temp = str.split(" ");
                        int[] scores = new int[numberOfStudents];
                        int[] scoresHistogram = new int[maxScore+1];
                        for (int i = 0; i < numberOfStudents; i++) {
                            scores[i] = Integer.parseInt(temp[i]);
                            try{
                                scoresHistogram[scores[i]]++;
                            }catch (Exception e){
                                System.out.println(i);
                                System.out.println(scores[i]);
                            }
                        }
                        int mode=0;
                        int modeScore=-1;
                        for (int i = maxScore ; 0<=i ; i--){
                            if(mode < scoresHistogram[i]){
                                mode = scoresHistogram[i];
                                modeScore = i;
                            }
                        }
                        System.out.println("#"+(testCase+1)+" "+modeScore);
                        testCase++;
                    }
                    isTestCase = !isTestCase;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

