package br.com.fiap.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.bean.Cliente;

public class Serializacao {
    public static void main(String[] args) throws Exception{
        Cliente cliente = new Cliente(1, "Pedro");
        FileOutputStream output = new FileOutputStream("objeto.txt");

        ObjectOutputStream out = new ObjectOutputStream(output);

        out.writeObject(cliente);

        out.close();
    }
}
