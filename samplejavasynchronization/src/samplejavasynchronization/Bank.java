package samplejavasynchronization;

public class Bank {

	  private int saldo = 1000;

	  // Metode tersinkronisasi untuk menambah saldo
	  public synchronized void setorTunai(int jumlah) {
	    saldo += jumlah;
	    System.out.println("Setor tunai Rp " + jumlah + ". Saldo baru: Rp " + saldo);
	  }

	  // Metode tersinkronisasi untuk menarik tunai
	  public synchronized void tarikTunai(int jumlah) throws TidakCukupSaldoException {
	    if (jumlah > saldo) {
	      throw new TidakCukupSaldoException("Saldo Anda tidak mencukupi untuk penarikan sebesar Rp " + jumlah);
	    }
	    saldo -= jumlah;
	    System.out.println("Penarikan tunai Rp " + jumlah + ". Saldo baru: Rp " + saldo);
	  }

	  // Blok tersinkronisasi untuk mengecek saldo (opsional)
	  public int cekSaldo() {
	    synchronized (this) { // Mengunci objek Bank saat mengecek saldo
	      return saldo;
	    }
	  }
	}
