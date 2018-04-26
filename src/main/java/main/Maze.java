package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze {
	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		frame.setSize(650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;
		//vị trí hiện tại (dùng trong thuật toán dfs)
		private int[] coordinate;
		//vị trí ngay trước đó (dùng trong thuật toán dfs)
		private int[] formerCoordinate;

		public MazePanel() {
			// Kích thước ma trận
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			coordinate = new int[2];
			formerCoordinate = new int[2];
			coordinate[0] = start;
			coordinate[1] = end;
			solve();
			repaint(); // vẽ ma trận và lời giải
		}

		/**
		 * Implement một phương pháp tìm đường nào đó.
		 * <p>
		 * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện các phần
		 * thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ tuyến đường chính
		 * đi từ điểm đầu (màu vàng) đến màu đỏ.
		 * <p>
		 * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu xanh
		 * dương hãy set giá trị của điểm trên ma trận sang một số > 2
		 */
		public void solve() {
			// Hàm này chứa phương pháp tìm đường từ điểm start đến vị
			// trí màu đỏ trên ma trận
			long startTime = System.nanoTime();
//			solveByDFS();
			solveByRealAStar();
			System.out.println("Execution time: " + ((System.nanoTime() - startTime)/1000000) + " ms");
		}
		
		
		/**
		 * Thay đổi toàn bộ quãng đường tìm được bởi A* thành giá trị 3</br>
		 * (ngoại trừ ô bắt đầu và ô kết thúc)
		 */
		public void solveByRealAStar() {
			for(int i : buildPathByAStar()) {
				if(i != 325) {
					int x = i % 31;
					int y = (int)Math.floor(i/31);
					maze[y][x] = 3;
				}
			}
		}
		
		/**
		 * Xây dựng quãng đường từ điểm xuất phát đến đích bằng A*
		 */
		public ArrayList<Integer> buildPathByAStar() {
			//Các điểm chưa được xét
			ArrayList<Integer> open = new ArrayList<Integer>();
			//Các điểm đã xét xong
			ArrayList<Integer> close = new ArrayList<Integer>();
			//Các điểm cùng với vị trí trước đó của nó
			HashMap<Integer,Integer> from = new HashMap<Integer,Integer>();
			//Value là quãng đường từ điểm xuất phát đến key
			HashMap<Integer,Integer> gScore = new HashMap<Integer,Integer>();
			//Value là quãng đường heurestic từ điểm xuất phát đi qua key để đến đích
			HashMap<Integer,Double> fScore = new HashMap<Integer,Double>();
			open.add(310);
			double lowestFscore;
			int pointWithLowestFS = 0;
			gScore.put(start*sizew + end, 0);
			fScore.put(start*sizew + end,distanceToDestination(start*sizew + end));
			while(open.size() != 0) {
				
				//tìm điểm có fscore nhỏ nhất
				lowestFscore = 1000;
				for(int pointInOpen : open) {
					if(fScore.get(pointInOpen) < lowestFscore) {
						pointWithLowestFS = pointInOpen;
						lowestFscore = fScore.get(pointInOpen);
					}
				}

				//Nếu là đích thì xây dựng đường đi và kết thúc
				if(distanceToDestination(pointWithLowestFS) == 0.0) {
					return reconstructPath(from,pointWithLowestFS);
				}
				
				open.remove((Integer)pointWithLowestFS);
				close.add((Integer)pointWithLowestFS);
				
				for(int neighbor : findNeighbors(pointWithLowestFS)) {
					//Nếu đã xét rồi thì thôi không xét nữa
					if(close.contains(neighbor)) {
						continue;
					}
					//Phát hiện điểm mới
					if(!open.contains(pointWithLowestFS)) {
						open.add(neighbor);
					}
					//Nếu đoạn đường hiện tại không hiệu quả bằng quãng đường đã tìm được thì thôi không xét nữa
					if((gScore.get(neighbor) != null) && (gScore.get(pointWithLowestFS) + 1 >= gScore.get(neighbor))) {
						continue;
					}
					
					//Cập nhật lại thông số của điểm đang xét
					from.put(neighbor,pointWithLowestFS);
					gScore.put(neighbor, gScore.get(pointWithLowestFS)+1);
					fScore.put(neighbor, (double)(gScore.get(neighbor)) + distanceToDestination(neighbor));
				}
				
			}
			return null;
		}
		
		
		/**
		 * Đầu vào là một map </br>
		 * key là các điểm nằm trên đường ngắn nhất</br>
		 * value là điểm mà từ đó đến được key</br>
		 * </br>
		 * Đầu ra là đường đi từ điểm xuất phát đến đích theo đúng thứ tự 
		 */
		public ArrayList<Integer> reconstructPath(HashMap<Integer,Integer> from,int current){
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(current);
			int c = current;
			while(from.get(c) != null) {
				c = from.get(c);
				path.add(c);
			}
			return path;
		}
		
		
		/**
		 * Tính khoảng cách từ 1 điểm đến đích</br>
		 * Đầu vào là số thứ tự của điểm đó (từ trái sang phải từ trên xuống dưới)</br>
		 * Số thứ tự này được tính bằng cách : ô [i][j] có số thứ tự bằng (31*i +j)</br>
		 */
		public double distanceToDestination(int current) {
			int x = current % 31;
			int y = (int)Math.floor(current/31);
			return Math.sqrt((x-15)*(x-15) + (10-y)*(10-y));
		}
		
		
		/**
		 * Tìm tất cả các ô lân cận của ô hiện tại mà không phải là tường</br>
		 */
		public ArrayList<Integer> findNeighbors(int current){
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			int x = current % 31;
			int y = (int)Math.floor(current/31);
			if(x == 0) {
				neighbors.add(311);
			}else {
				if(maze[y-1][x] == 0 || maze[y-1][x] == 2) {
					neighbors.add(current-31);
				}
				if(maze[y+1][x] == 0 || maze[y+1][x] == 2) {
					neighbors.add(current+31);
				}
				if(maze[y][x-1] == 0 || maze[y][x-1] == 2) {
					neighbors.add(current-1);
				}
				if(maze[y][x+1] == 0 || maze[y][x+1] == 2) {
					neighbors.add(current+1);
				}
			}
			return neighbors;
		}		
		
		/**
		 * Giải quyết bài toàn bằng dfs</br>
		 * Khi đến 1 ô bất kì, thứ tự xét các ô lân cận là: đi xuống dưới, đi sang phải, đi lên trên, đi sang trái</br></br>
		 * 	nếu có thể đi được xuống dưới thì đi xuống dưới</br>
		 * 	nếu không thì nếu đi được sang phải thì đi sang phải</br>
		 * 	nếu không thì nếu đi được lên trên thì đi lên trên</br>
		 * 	nếu không thì nếu đi được sang trái thì đi sang trái</br></br>
		 * nếu không đi được đâu thì quay lại đường cũ đến khi nào đi được</br>  
		 */
		public void solveByDFS() {
			while (maze[coordinate[0]][coordinate[1]] != 2) {
//				System.out.println(coordinate[0] + "\t" + coordinate[1]);
				if (nextToDestiny()) {
					if (maze[coordinate[0] + 1][coordinate[1]] == 2) {
						coordinate[0]++;
					} else if (maze[coordinate[0]][coordinate[1] - 1] == 2) {
						coordinate[1]--;
					} else if (maze[coordinate[0]][coordinate[1] + 1] == 2) {
						coordinate[1]--;
					} else {
						coordinate[0]--;
					}
				} else {
					if (downAvailable()) {
						moveDown();
					} else if (rightAvailable()) {
						moveRight();
					} else if (upAvailable()) {
						moveUp();
					} else if (leftAvailable()) {
						moveLeft();
					} else {
						goBack();
					}
				}
			}
		}

		
		/**
		 * Cách quay lại của khi gặp đường tắc (chỉ dùng trong dfs)</br>
		 */
		public void goBack() {
			maze[coordinate[0]][coordinate[1]] = 4;
			
			//quay lại vị trí ngay trước đó
			coordinate[1] = formerCoordinate[1];
			coordinate[0] = formerCoordinate[0];
			
			//thực hiện quay lại đến vị trí có thể đi tiếp
			// toàn bô đoạn đường vừa đi vào ngõ cụt được đánh số 4
			while ((!downAvailable()) && (!upAvailable()) && (!leftAvailable()) && (!rightAvailable())) {
				if (maze[coordinate[0] - 1][coordinate[1]] == 3) {
					maze[coordinate[0]][coordinate[1]] = 4;
					coordinate[0]--;
					if ((!downAvailable()) && (!upAvailable()) && (!leftAvailable()) && (!rightAvailable())) {
						maze[coordinate[0]][coordinate[1]] = 4;
					}
				} else if (maze[coordinate[0] + 1][coordinate[1]] == 3) {
					maze[coordinate[0]][coordinate[1]] = 4;
					coordinate[0]++;
					if ((!downAvailable()) && (!upAvailable()) && (!leftAvailable()) && (!rightAvailable())) {
						maze[coordinate[0]][coordinate[1]] = 4;
					}
				} else if (maze[coordinate[0]][coordinate[1] - 1] == 3) {
					maze[coordinate[0]][coordinate[1]] = 4;
					coordinate[1]--;
					if ((!downAvailable()) && (!upAvailable()) && (!leftAvailable()) && (!rightAvailable())) {
						maze[coordinate[0]][coordinate[1]] = 4;
					}
				} else if (maze[coordinate[0]][coordinate[1] + 1] == 3) {
					maze[coordinate[0]][coordinate[1]] = 4;
					coordinate[1]++;
					if ((!downAvailable()) && (!upAvailable()) && (!leftAvailable()) && (!rightAvailable())) {
						maze[coordinate[0]][coordinate[1]] = 4;
					}
				}
			}

		}
		
		/**
		 * Di chuyển lên trên</br>
		 */
		public void moveUp() {
			formerCoordinate[0] = coordinate[0];
			formerCoordinate[1] = coordinate[1];
			coordinate[0]--;
			maze[coordinate[0]][coordinate[1]] = 3;
		}

		/**
		 * Di chuyển xuống dưới</br>
		 */
		public void moveDown() {
			formerCoordinate[0] = coordinate[0];
			formerCoordinate[1] = coordinate[1];
			coordinate[0]++;
			maze[coordinate[0]][coordinate[1]] = 3;
		}

		/**
		 * Di chuyển sang trái</br>
		 */
		public void moveLeft() {
			formerCoordinate[0] = coordinate[0];
			formerCoordinate[1] = coordinate[1];
			coordinate[1]--;
			maze[coordinate[0]][coordinate[1]] = 3;
		}

		/**
		 * Di chuyển sang phải</br>
		 */
		public void moveRight() {
			formerCoordinate[0] = coordinate[0];
			formerCoordinate[1] = coordinate[1];
			coordinate[1]++;
			maze[coordinate[0]][coordinate[1]] = 3;
		}

		/**
		 * Kiểm tra nếu có thể đi được xuống dưới</br>
		 */
		public boolean downAvailable() {
			if (coordinate[0] != 20 && maze[coordinate[0] + 1][coordinate[1]] == 0) {
				return true;
			}
			return false;
		}

		/**
		 * Kiểm tra nếu có thể đi được lên trên</br>
		 */
		public boolean upAvailable() {
			// coordinate[0] la chieu doc, coordinate[1] la chieu ngang
			if (coordinate[0] != 0 && maze[coordinate[0] - 1][coordinate[1]] == 0) {
				return true;
			}
			return false;
		}

		/**
		 * Kiểm tra nếu có thể đi được sang trái</br>
		 */
		public boolean leftAvailable() {
			// coordinate[0] la chieu doc, coordinate[1] la chieu ngang
			if (coordinate[1] != 0 && maze[coordinate[0]][coordinate[1] - 1] == 0) {
				return true;
			}
			return false;
		}

		/**
		 * Kiểm tra nếu có thể đi được sang phải</br>
		 */
		public boolean rightAvailable() {
			// coordinate[0] la chieu doc, coordinate[1] la chieu ngang
			if (coordinate[1] != 30 && maze[coordinate[0]][coordinate[1] + 1] == 0) {
				return true;
			}
			return false;
		}

		/**
		 * Kiểm tra nếu ở sát đích</br>
		 */
		public boolean nextToDestiny() {
			if (coordinate[0] != 0 && coordinate[0] != 20 && coordinate[1] != 0 && coordinate[1] != 30) {
				if (maze[coordinate[0] + 1][coordinate[1]] == 2 || maze[coordinate[0]][coordinate[1] - 1] == 2
						|| maze[coordinate[0]][coordinate[1] + 1] == 2 || maze[coordinate[0] - 1][coordinate[1]] == 2) {
					return true;
				}
			}
			return false;
		}

		public void paintComponent(Graphics g) // vẽ ma trận + lời giải
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0 || maze[i][j] == 4)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else if (maze[i][j] == 3)
						g.setColor(Color.blue); // blue là màu của lời giải
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}
