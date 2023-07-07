import java.util.*;

public class l {
    public static int maxTotalEnergy(int[] energyCapacityOfCars, int[] powerOfoutlets, int hours) {
        Arrays.sort(energyCapacityOfCars);
        Arrays.sort(powerOfoutlets);

        int totalEnergy = 0;
        int carIndex = energyCapacityOfCars.length - 1;// max capacity of cars will be stored
        int outletIndex = powerOfoutlets.length - 1; // max power of outlet will be stored

        
        // totalEnergy = totalEnergy + powerOfoutlets[outletIndex] * hours;
        //     if (energyCapacityOfCars[carIndex] < totalEnergy) {
        //         return energyCapacityOfCars[carIndex];
                
        //     }
        // return totalEnergy;
        
        totalEnergy = totalEnergy + powerOfoutlets[outletIndex] * hours;
        while(carIndex >= 0 && outletIndex >= 0 && hours > 0){
            if (energyCapacityOfCars[carIndex] < totalEnergy) {
                totalEnergy = energyCapacityOfCars[carIndex];
                return totalEnergy;

            }
        }
            
        return totalEnergy;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        List<Integer> results = new ArrayList<>();

        for (int t = 0; t < a; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int h = scanner.nextInt();

            int[] energyCapacityOfCars = new int[n];
            for (int i = 0; i < n; i++) {
                energyCapacityOfCars[i] = scanner.nextInt();
            }

            int[] powerOfoutlets = new int[m];
            for (int i = 0; i < m; i++) {
                powerOfoutlets[i] = scanner.nextInt();
            }

            int maxEnergy = maxTotalEnergy(energyCapacityOfCars, powerOfoutlets, h);
            results.add(maxEnergy);
        }
        for (int result : results) {
            System.out.println(result);
        }

    }
}