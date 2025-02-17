package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    protected Maze maze;
    protected String[][] maze_arr;
    protected int[] dimensions;
    protected int[] current_position;
    protected int[] start_position;
    protected int[] end_position;
    protected Compass direction;
    protected String startingSide;

    Path(Maze maze, String startingSide) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();
        this.startingSide = startingSide;
    }

    protected void findWestOpening() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][0]) || maze_arr[i][0] == null ) {
                if (startingSide.equals("West")) {
                    start_position = new int[]{i, 0};
                    direction = new East();
                }
                else {
                    end_position = new int[]{i, 0};
                }
            }
        }
    }

    protected void findEastOpening() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][dimensions[1]-1]) || maze_arr[i][dimensions[1]-1] == null) {
                if (startingSide.equals("East")) {
                    start_position = new int[]{i, dimensions[1]-1};
                    direction = new West();
                }
                else {
                    end_position = new int[]{i, dimensions[1]-1};
                }
            }
        }
    }
}
