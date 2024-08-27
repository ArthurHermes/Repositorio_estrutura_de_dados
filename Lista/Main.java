package Lista;

public class Main {
    public static void main(String[] args){
        StaticList list = new StaticList(5);

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(35);

        System.out.println("Lista após adicionar elementos:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getData(i));
        }

        list.remove(1);

        System.out.println("Lista após remover elemento na posição 1:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getData(i));
        }

        list.setData(40, 1);
        System.out.println("Lista após definir novo valor na posição 1:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getData(i));
        }

        int pos = list.find(40);
        System.out.println("Posição do elemento 40: " + pos);
    }
        
}
