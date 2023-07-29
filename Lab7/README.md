| Outline | Value |
| ------- | ----- |
| Course | SEG 3503 |
| Professor | Mohammed Ibrahim |
| TA | Joesph Abonasara |
| Team | Brice Joan Ngnawo Soh - nsoh087@uottawa.ca - 300262882<br>Greg Nathan Ngongang Ouandji - gngon065@uottawa.ca - 300260560<br>Aaron Muganda - amuga022@uottawa.ca - 300246117 |

After running Spotbug, 17 bugs were identified and out of the 17 bugs, 15 bugs were solved. 
<h1>Bug Description</h1>
<h2><b>Bug 1: Bug kind and pattern: SW - SW_SWING_METHODS_INVOKED_IN_SWING_THREAD</b></h2>
<p>The corresponding peer for the frame will be created by the Swing methods show(), setVisible(), and pack(). The system creates the event dispatch thread concurrently with the formation of the peer. This complicates matters because listeners could be notified by the event dispatch thread while pack and validate are still working. It's a major weakness that could lead to deadlocks or other related threading problems that could result in two threads passing through the Swing component-based GUI in this circumstance. The realisation of components results from a pack call. They may cause listener notification on the event dispatch thread as they are realised (not necessarily visible, so to speak).</p>
<br>
<h2><b>Bug 2: Bug kind and pattern: SIC - SIC_INNER_SHOULD_BE_STATIC_ANON</b></h2>
<p>Despite being an inner class, this one does not make use of the reference to the object that produced it. This reference increases the size of the class instances and can keep the creator object reference active longer than is necessary. The class ought to be turned into a static inner class, if at all possible. This requires modifying the inner class to make it a named inner class because anonymous inner classes cannot be designated as static.</p>
