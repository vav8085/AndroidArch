package com.vav.java;

import java.util.*;

/**
 * In this example we will see how we can do collections.sort using a lambda expression
 */

public class Main {

    public static void main(String[] args) {
	    Agent lara = new Agent("Lara Croft", 1000);
        Agent jason = new Agent("Jason Bourne", 1005);
        Agent james = new Agent("James Bond", 007);
        Agent ethan = new Agent("Ethan Hunt", 1024);
        List<Agent> secretAgents = new ArrayList<>();
        secretAgents.add(lara);
        secretAgents.add(jason);
        secretAgents.add(james);
        secretAgents.add(ethan);

        //SORTING
        //....1....This is how we will write a collections .sort for this

//        Collections.sort(secretAgents, new Comparator<Agent>() {
//            @Override
//            public int compare(Agent e1, Agent e2) {
//                return e1.getName().compareTo(e2.getName());
//            }
//        });

        //....2....The same thing can be done using lambdas because Comparator is annotated with @FunctionalInterface
        //Even though comparator has 2 methods with no body the other method equals is actually overridden from
        //Object class.
        //This time we have to pass this lambda two arguments because the compare method takes two arguments.

        //Collections.sort(secretAgents,(Agent agent1, Agent agent2)->
        //        agent1.getName().compareTo(agent2.getName()));

        //....3....Now compiler here can further understand by looking at the first parameter of sort secretAgents that agent1 and
        //agent2 are of type Agent. So we dont need to explicitly mention that.
        Collections.sort(secretAgents,(agent1, agent2)->
                agent1.getName().compareTo(agent2.getName()));

        //Print the sorted list.
        for(Agent agent : secretAgents){
            System.out.println(agent.getName() + " : " + agent.getId());
        }

       // Upper Concat without lambdas, we are doing the same thing here as done above
       // We just created our own interface and passed it in the method.
//        System.out.println(getUpperConcat(new UpperConcat() {
//            @Override
//            public String UpperConcat(String s1, String s2) {
//                return s1.toUpperCase()+" "+s2.toUpperCase();
//            }
//        },lara.getName(),james.getName()));

        //Converting the above to lambda function

        UpperConcat uc = (s1,s2)-> s1.toUpperCase() + " " + s2.toUpperCase();
        System.out.println(getUpperConcat(uc,lara.getName(),james.getName()));

    }
    public static String getUpperConcat(UpperConcat uc, String s1, String s2){
        return uc.UpperConcat(s1,s2);
    }


}

/**
 * An employee class where we have employee with their name and ids.
 * We need to sort them using their names.
 */
class Agent {
    private String name;
    private int id;

    public Agent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

interface UpperConcat{
    public String UpperConcat(String s1, String s2);
}
