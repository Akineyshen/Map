# Map
This Java program is designed to analyze a geographical map represented as a 2D grid to find the largest contiguous area of land of a specific type and the longest river. Each cell in the grid is characterized by a unique symbol representing different terrains, such as 'x' for land and 'u' for water (rivers).

The program implements two main functionalities:
1. `Finding the Largest Area:` This function identifies the largest contiguous area of a specified land type ('x'). It uses Depth-First Search (DFS) to explore the grid, marking visited cells to avoid revisiting them and counting the size of each connected land area. It considers all eight directions (horizontal, vertical, and diagonal) from each cell to ensure all connected lands are accounted for.
2. `Finding the Longest River:` Similarly, this function locates the longest sequence of connected 'u' cells representing a river. It also employs DFS but limits exploration to four directions (up, down, left, right) since rivers flow more linearly compared to land spread. The length of each river is calculated, and the maximum length found during the search is returned.

The program reads from an input file `in.txt`, which contains the grid's dimensions followed by rows of terrain symbols. It first constructs the grid based on the input file, then applies the above functionalities to calculate and print the sizes of the largest land area and the longest river.

This approach demonstrates the application of DFS in solving problems related to graph theory and connected components, particularly useful in geographical information systems (GIS), gaming maps, and environmental studies to analyze and simulate natural terrains.
