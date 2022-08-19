package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    //@test
    public JobTest(){

    }
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals("Job Title", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("NASA", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Toronto", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality(){
        Job jobA = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobB = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobA.equals(jobB));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job testJob = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char lett[] = testJob.toString().toCharArray();
        assertEquals('\n', lett[lett.length-1]);
        assertEquals('\n', lett[0]);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String answer = "\nID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: " + job.getCoreCompetency() + "\n";
        assertEquals(job.toString(), answer);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Job Title", new Employer("NASA"), new Location("Toronto"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String answer = "\nID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + job.getEmployer() + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + job.getPositionType() + "\n" +
                "Core Competency: "+ job.getCoreCompetency() + "\n";
        assertEquals(job.toString(), answer);
    }
}