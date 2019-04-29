package com.minseungkwon.datastructure.Graph;

import java.util.HashMap;
import java.util.LinkedList;

class Project {
    private String name;
    private LinkedList<Project> dependencies;

    Project(String name) {
        this.name = name;
        this.dependencies = new LinkedList<>();
    }

    void addDependencies(Project p) {
        if (!dependencies.contains(p)) {
            dependencies.add(p);
        }
    }

    LinkedList<Project> getDependencies() {
        return dependencies;
    }

    String getName() {
        return name;
    }
}

public class ProjectManager {
    private HashMap<String, Project> projects;

    ProjectManager(String[] names, String[][] dependencies) {
        projects = new HashMap<>();
        makeProjectList(names);
        addAllDependencies(dependencies);
    }

    HashMap<String, Project> getProjects() {
        return projects;
    }


    void makeProjectList(String[] names) {
        for (String s : names) {
            projects.put(s, new Project(s));
        }
    }

    void addAllDependencies(String[][] dependencies) {
        for (String[] dependency : dependencies) {
            String before = dependency[0];
            String after = dependency[1];
            projects.get(after).addDependencies(projects.get(before));
        }
    }

    private int index = 0;

    public Project[] buildOrder() {
        Project[] result = new Project[projects.size()];
        HashMap<String, Boolean> marked = new HashMap<>();
        for (Project p : projects.values()) {
            marked.put(p.getName(), false);
        }
        for (Project p : projects.values()) {
            buildOrder(p, result, marked);
        }
        return result;
    }

    void buildOrder(Project p, Project[] result, HashMap<String, Boolean> marked) {
        for (Project d : p.getDependencies()) {
            if (!marked.get(d.getName())) {
                buildOrder(d, result, marked);
            }
        }
        if (!marked.get(p.getName())) {
            marked.replace(p.getName(), true);
            System.out.println(p.getName());
            result[index++] = p;
        }
    }
}
