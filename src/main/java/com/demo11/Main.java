package com.demo11;

public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 8;

        System.out.println("A      : " + BitOperations.toBinary(a));
        System.out.println("B      : " + BitOperations.toBinary(b));
        System.out.println("A & B  : " + BitOperations.toBinary(BitOperations.and(a, b)));
        System.out.println("A | B  : " + BitOperations.toBinary(BitOperations.or(a, b)));
        System.out.println("A ^ B  : " + BitOperations.toBinary(BitOperations.xor(a, b)));
        System.out.println("~A     : " + BitOperations.toBinary(BitOperations.not(a)));

        System.out.println("A << 1 : " + BitOperations.toBinary(BitOperations.shiftLeft(a, 1)));
        System.out.println("A >> 1 : " + BitOperations.toBinary(BitOperations.shiftRight(a, 1)));
        System.out.println("A >>> 1: " + BitOperations.toBinary(BitOperations.unsignedShiftRight(a, 1)));

        System.out.println("Bit 2 of A is set: " + BitOperations.isBitSet(a, 2));
        System.out.println("A with bit 4 set : " + BitOperations.toBinary(BitOperations.setBit(a, 4)));
    }
}