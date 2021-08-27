import java.util.Scanner;

public class Main {

    public static String[] model =  new String[10];

    public static java.util.Scanner scan = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList(){
        System.out.println("TO DO LIST");
        for(int i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + "." + " " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        showTodoList();
    }

    public static void addTodoList(String todo){
        //cek apakah model penuh
        var isFull = true;
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }
        //jika penuh kita melakukan resize ukuran array
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        //tambah ke posisi data yang arraynya null
        for(int i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for(int i = 0; i < 25; i++){
            addTodoList("Contoh Todo Ke :" + i);
        }

        showTodoList();
    }

    public static boolean removeTodoList(Integer number){
        if((number - 1) >= model.length){
            return false;
        }
        else if(model[number - 1] == null){
            return false;
        }
        else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++){
                if(i == (model.length - 1)){
                    model[i] = null;
                }
                else{
                    model[i] = model[i + 1];
                }

            }

            return true;
        }

    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scan.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    public static void viewShowTodoList(){
        while(true){
            showTodoList();
            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            }
            else if(input.equals("2")){
                viewRemoveTodoList();
            }
            else if(input.equals("x")){
                break;
            }
            else{
                System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("Menambah TO DO LIST");

        var todo = input("Todo(x Jika Batal)");

        if(todo.equals("x")){
            //batal
        }else{
            addTodoList(todo);
        }
    }

    public static void testviewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewShowTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("Menghapus TO DO LIST");

        var number = input("Nomor yang dihapus (x Jika Batal)");

        if(number.equals("x")){
            //batal
        }
        else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus todolist : " +number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }



}
