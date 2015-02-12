package pkg;

public class Simulation {

	public int run(){

		DataInputStream input = new DataInputStream(new FileInputStream("TRACE1.DAT"));
		byte[] bs = new byte[3];
		while(input.available() > 0){
			int x = input.read(bs);

			 for(byte b:bs){
			 	System.out.println(b);

			 }
			int address = (bs[2]<<16)&0x00ff0000|
			 					(bs[1]<<8)&0x0000ff00|
			 					(bs[0]<<0)&0x000000ff;
			System.out.println("_______________________________");
			System.out.println(address);
			System.out.println("_______________________________");

		}

		input.close();

	}

}
