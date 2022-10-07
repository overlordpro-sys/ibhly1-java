public class KTourDriver {
    public static void main (String[] args)
    {
    	int visited = 64;
    	while(visited > 12 )
    	{
           KTour tour = new KTour();
           tour.start();
           visited = tour.output();
    	}
    }
}
