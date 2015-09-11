import java.util.Scanner;

//class Anggota untuk menampung data nama, nim dan nilai
class Anggota{
   public String nama;
   public String nim;
   public int nilai;

   public Anggota(String nim,String nama,int nilai){ // Konstruktor class Anggota
   	  this.nama = nama;     //inisialisasi variabel nama
   	  this.nim = nim;       //inisialisasi variabel nim
   	  this.nilai = nilai;   //inisialisasi variabel nilai
   }
}

class Link {
    public Anggota data;
	public Link next;

	public Link(String nama, String nim, int nilai){ //konstruktor class Link
	  data = new Anggota(nama,nim,nilai); // inisialisasi data yang merupakan objek dari class Anggota
	 }
	public void displayLink(){
		System.out.print("\n nim        : "+data.nim+
			             "\n nama       : "+data.nama+
			             "\n nilai      : "+data.nilai+
			             "\n---------------------------");
	}
}

class LinkList{
	private Link first; //objek class Link

	public LinkList(){ // konstruktor class Link
		first = null;
	}
	public boolean isEmpty(){
		return(first==null);
	}
	public void insertFirst(String nim,String nama, int nilai){//method untuk menginput data
		Link newLink = new Link(nim,nama,nilai);
		newLink.next = first;
		first        = newLink;
	}

	public Link find(String key){ //method untuk pencarian di linked list
		Link current = first;
		while (current.data.nama.equalsIgnoreCase(key)==false) { //proses pencocokan key dengan data
			if (current.next==null) {
				return null;
			}
			else{
                current = current.next;
			}			
		}
		return current;
	}

	public Link delete(String key){//method untuk menghapus linked list
		Link current = first;
		Link prev  = first;
		while (current.data.nama.equalsIgnoreCase(key)==false) {
			if (current.next==null) {
				return null;
			}
			else{
                prev = current;
                current = current.next;
			}			
		}
		if (current==first) {
			first=first.next;
		}
		else{
			prev.next=current.next;
		}
		return current;
	}

	public void sb ()
		{
		String tempNIM; 
 	 	String tempNama; 
		int tempNilai; 
		Link current = first; 
 	 	Link current2 = first; 
 
 	 	while (current!=null) { 
 	 	 	while (current2!=null) { 
                if (current2.next!=null) {     
 	 	 	 	    if (current2.data.nim.compareTo(current2.next.data.nim)<0) 
					{ 
						tempNIM = current2.data.nim; 
						current2.data.nim = current2.next.data.nim; 
						current2.next.data.nim = tempNIM; 
						
						tempNama = current2.data.nama; 
						current2.data.nama = current2.next.data.nama; 
						current2.next.data.nama = tempNama; 
						
						tempNilai = current2.data.nilai; 
						current2.data.nilai = current2.next.data.nilai; 
						current2.next.data.nilai = tempNilai; 
					} 
                } 	 	 	  	 	 	 	
				current2 = current2.next; 
 	 	 	} 
 	 	 	current2 = first; 
 	 	 	current = current.next; 
 	 	} 
	}
	
	public void sorting()
		{ 
		String temp; 
 	 	Link current = first; 
 	 	Link current2 = first; 
 
 	 	while (current!=null) { 
 	 	 	while (current2!=null) { 
                if (current2.next!=null) {     
 	 	 	 	    if (current2.data.nim.compareTo (current2.next.data.nim)<0) { 
						temp = current2.data.nim; 
						current2.data.nim = current2.next.data.nim; 
						current2.next.data.nim = temp; 
					} 
                } 	 	 	  	 	 	 	
				current2 = current2.next; 
 	 	 	} 
 	 	 	current2 = first; 
 	 	 	current = current.next; 
 	 	} 
		}

		
	public void displayList(){
		System.out.print("Data anggota: \n");
		Link current = first;
		int i =1;

		while (current!=null) {
			System.out.print(i+".");
			current.displayLink();
			current=current.next;	
			System.out.println();
			i++;			
	}
	System.out.println();
  }
}
class uas {
	public static void main(String[] args) {
		LinkList theList = new LinkList(); //objek dari class LinkList
		Scanner sc = new Scanner(System.in);
		String nim,nama,key;
		int nilai,jml,j,pil=1;
        System.out.print("=======================================\n");
        System.out.print("|             DATA ANGGOTA             |\n");
        System.out.print("=======================================\n");
      
        while ((pil>=1) && (pil<=6) ) {
        	System.out.print("1. Input data anggota \n");
            System.out.print("2. Cari Data \n");
            System.out.print("3. Urutkan data \n");
            System.out.print("4. Tampil data \n");
            System.out.print("5. Hapus Data \n");
            System.out.print("6. Keluar \n");
            System.out.print("masukan pilihan anda : ");
            pil = sc.nextInt();
        	if (pil==1) {
        		    Scanner sc2 = new Scanner(System.in);
        		    System.out.print("Masukan jumlah data yang akan di input : ");
			        jml = sc.nextInt();
			        j=1;
			        while (j<=jml) {
			        	System.out.println("data ke-"+(j));
			        	System.out.print("nim        : ");
			        	nim=sc2.nextLine();
			        	System.out.println();
			        	System.out.print("nama       : ");
			        	nama=sc2.nextLine();
			        	System.out.println();
			        	System.out.print("nilai      : ");
			        	nilai=sc.nextInt();
			        	System.out.println();
			        	theList.insertFirst(nim,nama,nilai);
			        	j++;
			        }
        	}
        	else if (pil==2) {       
        	    Scanner sc3 = new Scanner(System.in); 		
        		System.out.print("masukan nama yang akan dicari : ");
                key = sc3.nextLine();
				Link f = theList.find(key);
				if (f==null) {
					System.out.println("data "+key+" tidak ditemukan");
				}
				else{
					System.out.println("data "+key+" ditemukan");
				}
		        System.out.println();
        	}

        	else if (pil==3) 
				{     
				System.out.println (" Cara Pencarian !!! ");
				System.out.println (" 1. Booble Sort  ");
				System.out.println (" 2. Selection Sort ");
				pil = sc.nextInt();
				switch (pil)
				{
					case 1:
						theList.sorting();
					break;
					
					case 2:
						
					break;
				}
        		theList.displayList();
				}

        	else if (pil==4) {
        		theList.displayList();
        	}

        	else if (pil==5) {       			
		        theList.displayList();
        	}
        }
        System.exit(0);
  	
	}
}


