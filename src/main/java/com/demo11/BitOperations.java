package com.demo11;

public abstract class BitOperations {
    /**
     * Left shift (<<): shifts bits to the left by n positions, equivalent to multiplying by 2^n.
     */
    public static int shiftLeft(int value, int positions) {
        return value << positions;
    }

    /**
     * Right shift with sign (>>): shifts bits to the right, preserving the sign bit (arithmetic shift).
     */
    public static int shiftRight(int value, int positions) {
        return value >> positions;
    }

    /**
     * Unsigned right shift (>>>): shifts bits to the right, inserting zeros from the left (logical shift).
     */
    public static int unsignedShiftRight(int value, int positions) {
        return value >>> positions;
    }

    /**
     * Checks whether the bit at position `pos` is set to 1.
     * Bit positions start from 0 (least significant bit).
     */
    public static boolean isBitSet(int value, int pos) {
        return (value & (1 << pos)) != 0;
    }

    /**
     * Sets the bit at position `pos` to 1.
     */
    public static int setBit(int value, int pos) {
        return value | (1 << pos);
    }

    /**
     * Clears (sets to 0) the bit at position `pos`.
     */
    public static int clearBit(int value, int pos) {
        return value & ~(1 << pos);
    }

    /**
     * Toggles the bit at position `pos` (1 becomes 0, 0 becomes 1).
     */
    public static int toggleBit(int value, int pos) {
        return value ^ (1 << pos);
    }

    /**
     * Counts the number of bits set to 1 in the given integer.
     */
    public static int countSetBits(int value) {
        return Integer.bitCount(value);
    }

    /**
     * Checks if a number is even using bitwise operation.
     */
    public static boolean isEven(int value) {
        return (value & 1) == 0;
    }

    /**
     * Checks if a number is negative.
     */
    public static boolean isNegative(int value) {
        return value < 0;
    }

    // <editor-fold desc="Bitwise Operations">
    /**
     * Bitwise AND (&): keeps bits that are 1 in both numbers.
     */
    public static int and(int a, int b) {
        return a & b;
    }

    /**
     * Bitwise OR (|): keeps bits that are 1 in either number.
     */
    public static int or(int a, int b) {
        return a | b;
    }

    /**
     * Bitwise XOR (^): keeps bits that are 1 in one number but not both.
     */
    public static int xor(int a, int b) {
        return a ^ b;
    }

    /**
     * Bitwise NOT (~): inverts all bits (1 becomes 0, 0 becomes 1).
     */
    public static int not(int a) {
        return ~a;
    }
    // </editor-fold>

    /**
     * Returns the 32-bit binary string representation of an integer.
     */
    public static String toBinary(int value) {
        return String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');
    }
}
