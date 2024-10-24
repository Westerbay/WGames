package games.wester.util;

/*
 * Wester
 * This code is open source and free to use.
 *
 * You are free to copy, modify, and distribute this file without restriction.
 * No warranties are provided, and any use of this code is at your own risk.
 */

/**
 * @author Wester
 */
@FunctionalInterface
public interface ClassGenerator<E> {
    E generate();
}
