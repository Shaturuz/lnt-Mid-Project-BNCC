package lntMidProj;

import java.util.*;

//import Latihan.Employee;

import java.io.BufferedReader;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	Vector<Employee> data = new Vector<Employee>();
	int countManager = 0, idM = 1;
	int countSupervisor = 0, idS = 1;
	int countAdmin = 0, idA = 1;
	
	// clear buffer
	void clear() {
		for (int i = 0; i < 30; i++) {
			System.out.println(" ");
		}
	}
	
	// show list
	int show() {
		int counter = 0;
		String kode, nama, gender, jabatan;
		double gaji;
		
					//		   4		 15						30					15				14				15
		System.out.println("|----|---------------|------------------------------|---------------|--------------|---------------|");
		System.out.println("| No | Kode Karyawan | Nama Karyawan                | Jenis Kelamin | Jabatan      | Gaji Karyawan |");
		System.out.println("|----|---------------|------------------------------|---------------|--------------|---------------|");
		
		if(data.isEmpty()) {
		System.out.println("|    |               |                              |               |              |               |");
		}
		else {
			for (int i = 0; i < data.size(); i++) {
				
				kode = data.get(i).getKode();
				nama = data.get(i).getNama();
				gender = data.get(i).getGender();
				jabatan = data.get(i).getJabatan();
				gaji = data.get(i).getGaji();
				
				System.out.printf("| %2d | %13s | %28s | %13s | %12s | %13.0f |\n", (i+1), kode, nama, gender, jabatan, gaji);
				counter++;
			}
		}
		
		System.out.println("|----|---------------|------------------------------|---------------|--------------|---------------|");
		
		
		return counter;
	}
	
	void sortByNama() {
		
		data.sort(new Comparator<>() {
			//sorting salary ascending
//			public int compare(Employee a, Employee b) {
//				if(a.getSalary() == b.getSalary()) return 0;
//				else if(a.getSalary() < b.getSalary()) return 1;
//				else return -1;
//			}
			
			//sorting nama ascending
			public int compare(Employee x, Employee y) {
				return x.getNama().compareTo(y.getNama());
			}
			
		});
		
	}
	
	// menu
	void menu() {
		
//		sortByNama();
		
		int input = 0;
		
		do {
			clear();
			sortByNama();
			System.out.println("Employee Database");
			System.out.println("==================");
			System.out.println("1. Add new Employee");
			System.out.println("2. View all Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print(">> ");
			input = sc.nextInt();
			
			sc.nextLine();
			
			if (input == 1) {
				insertEmployee();
			}
			else if (input == 2) {
				viewEmployee();
			}
			else if (input == 3) {
				updateEmployee();
			}
			else if (input == 4) {
				deleteEmployee();
			}
		} while (input != 5);
		
	}
	
	// insert employee
	void insertEmployee() {
		
		String kode, nama, gender, jabatan;
		double gaji;
		
//		Random rand = new Random();
		
		int cek = 0;
		
		do{
			
			cek = 0;
			
			System.out.print("Input kode karyawan [contoh: AB-123]: ");
			kode = sc.nextLine();
			
			for(int i=0; i < data.size(); i++){
				
				if(kode.equals(data.get(i).getKode())) {
					cek = 1;
					break;
				}
				
			}
			
		}while(cek == 1);
		
//		sc.nextLine();
		
		
		System.out.print("Input nama karyawan [>=3]: ");
		nama = sc.nextLine();
		
		System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		gender = sc.nextLine();
		
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
			
			if(jabatan.equals("Manager")) {
				gaji = 8000000;
				System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
				
				if(countManager == 3 * idM) {
					
					int x = 0;
					
					System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
					
					for(int i = 0; i < data.size(); i++) {
						
						String Pkode, Pnama, Pgender, Pjabatan;
						double Pgaji;
						
						if(data.get(i).getJabatan().equals("Manager")) {
							
							Pkode = data.get(i).getKode();
							Pnama = data.get(i).getNama();
							Pgender = data.get(i).getGender();
							Pjabatan = data.get(i).getJabatan();
							Pgaji = data.get(i).getGaji();
							
							Pgaji = Pgaji + (Pgaji * 0.1);
							data.set(i, new Employee(Pkode, Pnama, Pgender, Pjabatan, Pgaji));
							
							if(x == 0) {
								System.out.print(Pkode);
								x = 1;
							}
							else if(i < data.size()) {
								System.out.print(", " + Pkode);
							}
							
						}
						
					}
					
					idM++;
					System.out.println("");
				}
				
				countManager++;
				data.add(new Employee(kode, nama, gender, jabatan, gaji));
				
			}
			else if(jabatan.equals("Supervisor")) {
				gaji = 6000000;
				System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
				
				if(countSupervisor == 3 * idS) {
					
					int x = 0;
					
					System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan id ");
					
					for(int i = 0; i < data.size(); i++) {
						
						String Pkode, Pnama, Pgender, Pjabatan;
						double Pgaji;
						
						if(data.get(i).getJabatan().equals("Supervisor")) {
							
							Pkode = data.get(i).getKode();
							Pnama = data.get(i).getNama();
							Pgender = data.get(i).getGender();
							Pjabatan = data.get(i).getJabatan();
							Pgaji = data.get(i).getGaji();
							
							Pgaji = Pgaji + (Pgaji * 0.075);
							data.set(i, new Employee(Pkode, Pnama, Pgender, Pjabatan, Pgaji));
							
							if(x == 0) {
								System.out.print(Pkode);
								x = 1;
							}
							else if(i < data.size()) {
								System.out.print(", " + Pkode);
							}
						}
						
					}
					
					idS++;
					System.out.println("");
				}
				
				countSupervisor++;
				data.add(new Employee(kode, nama, gender, jabatan, gaji));
				
			}
			else if(jabatan.equals("Admin")) {
				gaji = 4000000;
				System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
				
				if(countAdmin == 3 * idA) {
					
					int x = 0;
					
					System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
					
					for(int i = 0; i < data.size(); i++) {
						
						String Pkode, Pnama, Pgender, Pjabatan;
						double Pgaji;
						
						if(data.get(i).getJabatan().equals("Admin")) {
							
							Pkode = data.get(i).getKode();
							Pnama = data.get(i).getNama();
							Pgender = data.get(i).getGender();
							Pjabatan = data.get(i).getJabatan();
							Pgaji = data.get(i).getGaji();
							
							Pgaji = Pgaji + (Pgaji * 0.05);
							data.set(i, new Employee(Pkode, Pnama, Pgender, Pjabatan, Pgaji));
							
							if(x == 0) {
								System.out.print(Pkode);
								x = 1;
							}
							else if(i < data.size()) {
								System.out.print(", " + Pkode);
							}
							
						}
						
					}

					idA++;
					System.out.println("");
				}
				
				countAdmin++;
				data.add(new Employee(kode, nama, gender, jabatan, gaji));
		
			}
			
			
		}while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
//		data.add(new Employee(kode, nama, gender, jabatan, gaji));
		
		System.out.println("ENTER to return");
		sc.nextLine();
		
	}
	
	void viewEmployee() {
		
		clear();
		int counter = 0;
		
		if(data.isEmpty()) {
			System.out.println("Tidak ada data");
			
			System.out.println("ENTER to return");
			sc.nextLine();
			return;
		}
		
		counter = show();
		
		System.out.println("ENTER to return");
		
		sc.nextLine();
	}
	
	void updateEmployee() {
		
		clear();
		int counter = 0;
		
		if(data.isEmpty()) {
			System.out.println("Tidak ada data");
			
			System.out.println("ENTER to return");
			sc.nextLine();
			return;
		}
		
		counter = show();
		
		int inputNumber = 0;
		
		do {
			System.out.print("Input nomor urutan karyawan yang ingin di-update [Enter 0 to cancel]: ");
			inputNumber = sc.nextInt();
			sc.nextLine();
			
			if (inputNumber == 0) {
//				System.out.println("ENTER to return");
//				sc.nextLine();
				break;
			}
		} while (inputNumber != 0 && inputNumber > counter);
		
		if(inputNumber != 0) {
			
			int idx = inputNumber - 1;
			
			// masukkan data
			String kode, nama, gender, jabatan;
			double gaji;
			
			kode = data.get(idx).getKode();
			nama = data.get(idx).getNama();
			gender = data.get(idx).getGender();
			jabatan = data.get(idx).getJabatan();
			gaji = data.get(idx).getGaji();
			
			String Unama, Ugender, Ujabatan;
			double Ugaji = 0;
			
			System.out.println("Enter 0 to skip");
			
			System.out.print("Input nama karyawan [>=3]: ");
			Unama = sc.nextLine();
			
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			Ugender = sc.nextLine();
			
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			Ujabatan = sc.nextLine();
			
			if(Ujabatan.equals("Manager")) {
				Ugaji = 8000000;
			}
			else if(Ujabatan.equals("Supervisor")) {
				Ugaji = 6000000;
			}
			else if(Ujabatan.equals("Admin")) {
				Ugaji = 4000000;
		
			}
			
			if(!Unama.equals("0")) nama = Unama;
			if(!Ugender.equals("0")) gender = Ugender;
			if(!Ujabatan.equals("0") || Ujabatan.equals("Manager") || Ujabatan.equals("Supervisor") || Ujabatan.equals("Admin")) {
				jabatan = Ujabatan;
			}
			if(Ugaji != 0) gaji = Ugaji;
			
			data.set(idx, new Employee(kode, nama, gender, jabatan, gaji));
			
			System.out.println("Berhasil mengupdate karyawan dengan id " + kode);
			
		}
		
		
		System.out.println("ENTER to return");
		sc.nextLine();
		
	}
	
	void deleteEmployee() {
		
		clear();
		int counter = 0;
		
		if(data.isEmpty()) {
			System.out.println("Tidak ada data");
			
			System.out.println("ENTER to return");
			sc.nextLine();
			return;
		}
		
		counter = show();
		
		int delNumber = 0;
		
		do {
			System.out.println("Input nomor urutan karyawan yang ingin dihapus [Enter 0 to cancel]: ");
			delNumber = sc.nextInt();
			sc.nextLine();
			
			if (delNumber == 0) {
//				System.out.println("ENTER to return");
//				sc.nextLine();
				break;
			}
		} while (delNumber > data.size());
		
		if (delNumber != 0) {
			int index = delNumber - 1;
			System.out.println("Karyawan dengan kode " + data.get(index).getKode() + " berhasil dihapus");
			data.remove(index);
		}
		
		System.out.println("ENTER to return");
		sc.nextLine();
		
	}
	
	
	public Main(){
		
		menu();
		
		
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
