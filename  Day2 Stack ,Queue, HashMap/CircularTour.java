class CircularTour {
    // Function to find the starting point for the circular tour
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalPetrol = 0;  // Total petrol in the journey
        int totalDistance = 0;  // Total distance to be covered
        int currentPetrol = 0;  // Petrol available in the current tour
        int start = 0;  // Starting pump index
        
        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            
            currentPetrol += petrol[i] - distance[i];
            
            // If current petrol goes negative, we can't start from the current 'start'
            if (currentPetrol < 0) {
                // Reset starting pump to the next one
                start = i + 1;
                currentPetrol = 0;
            }
        }
        
        // If the total petrol is greater than or equal to total distance, return the start
        if (totalPetrol >= totalDistance) {
            return start;
        }
        
        // Otherwise, it's not possible to complete the tour
        return -1;
    }


    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        int start = findStartingPump(petrol, distance);
        
        if (start == -1) {
            System.out.println("No solution exists.");
        } else {
            System.out.println("The circular tour can start at pump " + start);
        }
    }
}
