public class BadThreadParamTest  {
    static class BadThreadParam implements Runnable {
        static int c;

        public BadThreadParam( int a, int b ) {
            c = a + b;
        }

        public void run() {
            System.out.println( c );
        }
    }
    
    static class ImmutableThreadParam implements Runnable {
        private final int c;

        public ImmutableThreadParam( int a, int b ) {
            c = a + b;
        }

        public void run() {
            System.out.println( c );
        }
    }
    
    static class ThreadSafeMutableThreadParam implements Runnable {
        private int c;

        public ThreadSafeMutableThreadParam( int a, int b ) {
            c = a + b;
        }
        
        public synchronized void setC( int c ) {
            this.c = c;
        }
        
        public synchronized int getC() {
            return c;
        }

        public void run() {
            System.out.println( getC() );
        }
    }
    

    public static void main( String[] args ) {
        Runnable btp3 = new BadThreadParam( 1, 2 );
        Runnable btp5 = new BadThreadParam( 3, 2 );
        btp3.run();  // Expect 3 but is 5.  WTF?
        btp5.run();  // Expect 5.

        Runnable expect3 = new ImmutableThreadParam( 1, 2 );
        Runnable expect5 = new ImmutableThreadParam( 3, 2 );
        expect3.run();  // Expect 3.
        expect5.run();  // Expect 5.

        Runnable tsmtp3 = new ThreadSafeMutableThreadParam( 1, 2 );
        Runnable tsmtp5 = new ThreadSafeMutableThreadParam( 3, 2 );
        tsmtp3.run();  // Expect 3.
        tsmtp5.run();  // Expect 5.

    }

}
