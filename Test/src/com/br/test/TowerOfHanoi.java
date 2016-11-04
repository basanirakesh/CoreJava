package com.br.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {
	public static void main(String[] args) {
		// Creating 3 poles
		List<Stack<Integer>> poles = new ArrayList<>();
		Stack<Integer> pole1 = new Stack<>();
		Stack<Integer> pole2 = new Stack<>();
		Stack<Integer> pole3 = new Stack<>();

		poles.add(pole1);
		poles.add(pole2);
		poles.add(pole3);

		// Loading inputs to pole1
		loadInputs(pole1);

		int inputPoleSize = pole1.size();
		int index = 0;
		int nextIndex = 0;
		int numberOfMoves = 0;
		Stack<Integer> currentPole = null;
		Stack<Integer> nextPole = null;
		Integer lastMovedElement = null;
		// Integer numberOfItemsPoppedFromCurrentPole = null;
		while (poles.get(poles.size() - 1).size() != inputPoleSize) {
			currentPole = poles.get(index);
			if (currentPole.isEmpty() || currentPole.peek() == lastMovedElement) {
				index = getNextIndex(inputPoleSize, poles.size(), index);
				continue;
			}
			nextIndex = getNextIndex(inputPoleSize, poles.size(), index);
			for (int i = 0; i <= poles.size() - 2; i++) {
				nextPole = poles.get(nextIndex);
				if (currentPole.isEmpty() == false && (nextPole.isEmpty() || nextPole.peek() > currentPole.peek())) {
					lastMovedElement = currentPole.peek();
					nextPole.push(currentPole.pop());
					numberOfMoves++;
				}
				nextIndex = getNextIndex(inputPoleSize, poles.size(), nextIndex);
			}
			index = getNextIndex(inputPoleSize, poles.size(), index);
		}

		System.out.println("Number of moves = " + numberOfMoves + ", Result =" + poles);
	}
	
	private static void loadInputs(Stack<Integer> pole) {
		pole.push(10);
		pole.push(9);
		pole.push(8);
		pole.push(7);
		pole.push(6);
		pole.push(5);
		pole.push(4);
		pole.push(3);
		pole.push(2);
		pole.push(1);
	}

	private static int getNextIndex(int inputPoleSize, int numberOfPoles, int nextIndex) {
		if (inputPoleSize % 2 == 0) {
			nextIndex = nextIndex + 1;
			if (nextIndex == numberOfPoles)
				nextIndex = 0;
		} else {
			nextIndex = nextIndex - 1;
			if (nextIndex == -1)
				nextIndex = numberOfPoles - 1;
		}
		return nextIndex;
	}
}
