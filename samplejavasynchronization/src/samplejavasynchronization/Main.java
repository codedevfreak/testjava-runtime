package samplejavasynchronization;

public class Main {
	  public static void main(String[] args) {
	    Bank myBank = new Bank();

	    // Thread untuk setor tunai
	    Thread setorThread = new Thread(() -> {
	      myBank.setorTunai(500);
	    });

	    // Thread untuk tarik tunai
	    Thread tarikThread = new Thread(() -> {
	      try {
	        myBank.tarikTunai(700);
	      } catch (TidakCukupSaldoException e) {
	        System.err.println(e.getMessage());
	      }
	    });

	    // Jalankan kedua thread secara bersamaan
	    setorThread.start();
	    tarikThread.start();
	  }
	}
