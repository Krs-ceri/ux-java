package ai;

import javafx.scene.control.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class AI {
    //CHAMPS ...
    public static HashMap<double[], double[]> mapTrain;
    public static HashMap<double[], double[]> mapTest;
    public static HashMap<double[], double[]> mapDev;
    private int names;
    private int[] layers;
    private double error;
    private double samples;
    private MultiLayerPerceptron net;

    public AI(String name) {
       this.names = Integer.parseInt(name);			
        this.samples = samples;
        layers = new int[]{9, 5, 9};
        switch (names) {
		case 1:
			net = MultiLayerPerceptron.load("data/1");
			break;
		case 2:
			net = MultiLayerPerceptron.load("data/2");
			break;

		case 3:
			net = MultiLayerPerceptron.load("data/3");
			break;

		default:
			break;
		}
        
        if (net == null) {
            net = new MultiLayerPerceptron(layers, 0.1, new SigmoidalTransferFunction());
        }
    }

    public static void test() {
        try {
            AI aiEasy = new AI("1");
            AI aiMedium = new AI("2");
            AI aiHard = new AI("3");
            File file = new File("data/data");
            aiEasy.trainFromData(file, 1000);
            aiMedium.trainFromData(file, 10000);
            aiHard.trainFromData(file, 100000);
            /*double[] inputs = {
                    1, 0, 2,
                    1, 0, 0,
                    0, 0, 2
            };
            aiHard.play(inputs);*/
        } catch (Exception e) {
            System.out.println("AI.test()");
            e.printStackTrace();
            System.exit(-1);
        }
    }

  

    public void trainFromData(File file, double samples) {
        try {
            if (file.exists()) {
                HashMap<double[], double[]> data = new HashMap<>();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    double[] in = getArray(line.split("\t")[0].split(","));
                    double[] out = getArray(line.split("\t")[1].split(","));
                    data.put(in, out);
                }
                for (int i = 0; i < samples; ++i) {
                    for (double[] input : data.keySet()) {
                        double[] output = data.get(input);
                        net.backPropagate(input, output);
                    }
                    System.out.println(i);
                }
                System.out.println("Learning complete");
                File directory = new File("ai");
                if (!directory.exists()) {
                    directory.mkdir();
                }
                net.save("ai/" + names);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trainFromDataWithProgressBar(File file, double samples, ProgressBar progressBar) {
        try {
            if (file.exists()) {
                HashMap<double[], double[]> data = new HashMap<>();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    double[] in = getArray(line.split("\t")[0].split(","));
                    double[] out = getArray(line.split("\t")[1].split(","));
                    data.put(in, out);
                }
                for (double i = 0; i < samples; ++i) {
                    for (double[] input : data.keySet()) {
                        double[] output = data.get(input);
                        net.backPropagate(input, output);
                    }
                    progressBar.setProgress(i/samples);
                }
                System.out.println("Learning complete");
                File directory = new File("ai");
                if (!directory.exists()) {
                    directory.mkdir();
                }
                net.save("ai/" + names);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int play(double[] inputs) {
        //TEST ...
        double[] outputs = net.forwardPropagation(inputs);

        for (double d : outputs) {
            System.out.println(d);
        }

        if (Arrays.stream(outputs).max().isPresent()) {
            double max = 0;
            int indexMax = 0;
            for (int i = 0; i < outputs.length; ++i) {
                if (inputs[i] == 0 && outputs[i] > max) {
                    max = outputs[i];
                    indexMax = i;
                }
            }
            return indexMax;
        }
        return -1;
    }

    public static double[] getArray(String[] t) {
        try {
            double[] array = new double[t.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = new Double(t[i]);
            }
            return array;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            System.out.println("Test.main()");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
