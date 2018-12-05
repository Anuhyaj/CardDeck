package test.nml.skill;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exm.nml.skill.Play;

public class TestPlay {

@Test
public void testPlay()
{
	Play play = new Play(-1);
	assertEquals("Test for a Bad Input",400,play.getStatus());
	play = new Play(6);
	assertEquals("Test for a valid Input",200,play.getStatus());
	play.shuffle();
	play.deal();
	assertEquals("Test for a Valid Deal",200,play.getStatus());
}


}
