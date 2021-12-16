class AnimalShelf {

    private Queue<int[]> queueCat = new LinkedList<>();
    private Queue<int[]> queueDog = new LinkedList<>();

    public AnimalShelf() {
    }

    public void enqueue(int[] animal) {
        if (animal[1]==1) {
            queueDog.add(animal);
        } else {
            queueCat.add(animal);
        }
    }

    public int[] dequeueAny() {
        if (queueCat.isEmpty() && queueDog.isEmpty()) {
            return new int[]{-1,-1};
        }
        if (queueDog.isEmpty()) {
            return queueCat.poll();
        }
        if (queueCat.isEmpty()) {
            return queueDog.poll();
        } 
        if (queueDog.peek()[0] < queueCat.peek()[0]) {
            return queueDog.poll();
        } else {
            return queueCat.poll();
        }
    }

    public int[] dequeueDog() {
        if (queueDog.isEmpty()) {
            return new int[]{-1,-1};    
        } 
        return queueDog.poll();
    }

    public int[] dequeueCat() {
        if (queueCat.isEmpty()) {
            return new int[]{-1,-1};
        }
        return queueCat.poll();
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
