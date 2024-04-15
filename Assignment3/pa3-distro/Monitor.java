/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor {
	/*
	 * ------------
	 * Data members
	 * ------------
	 */

	// enum State {
	// THINKING, HUNGRY, EATING, TALKING
	// }

	// private State philState[];

	private boolean philosopherIsTalking;
	private int chopsticks[];

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers) {
		this.chopsticks = new int[piNumberOfPhilosophers]; // 0 = available, 1 = taken
		this.philosopherIsTalking = false;
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */
	public boolean closestChopsticksAvailable(int leftChopstick, int rightChopstick) {
		return chopsticks[leftChopstick] == 0 && chopsticks[rightChopstick] == 0;
	}

	public int[] getChopstickIndices(int piTID) {
		int philIndex = piTID - 1;

		int leftIndex = (philIndex + (chopsticks.length - 1)) % chopsticks.length;
		int rightIndex = (philIndex + 1) % chopsticks.length;

		return new int[] { leftIndex, rightIndex };
	}

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) {
		int[] chopstickIndices = getChopstickIndices(piTID);
		int left = chopstickIndices[0];
		int right = chopstickIndices[1];

		// Check if the chopsticks next to the philosopher are available
		while (!closestChopsticksAvailable(left, right)) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Monitor.pickUp():");
				DiningPhilosophers.reportException(e);
				System.exit(1);
			}
		}
		// Set the chopsticks to taken
		chopsticks[left] = 1;
		chopsticks[right] = 1;
		// Let the philosopher eat
		return;
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID) {
		int[] chopstickIndices = getChopstickIndices(piTID);
		int left = chopstickIndices[0];
		int right = chopstickIndices[1];

		// Set the chopsticks to available
		chopsticks[left] = 0;
		chopsticks[right] = 0;
		// Notify other philosophers that the chopsticks are available
		notifyAll();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk() {
		// If someone is already talking, wait
		while (philosopherIsTalking) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Monitor.requestTalk():");
				DiningPhilosophers.reportException(e);
				System.exit(1);
			}
		}

		// Set the monitor flag for talking to true
		philosopherIsTalking = true;
		// Let the philosopher talk
		return;
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk() {
		// Set the monitor flag for talking to false
		philosopherIsTalking = false;
		// Notify other philosophers that they can talk
		notifyAll();
	}
}
