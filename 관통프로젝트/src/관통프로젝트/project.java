package 관통프로젝트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 순서 : {맨시티, 맨유, 리버풀, 토트넘, 첼시, 뉴캐슬, 아스날, QPR, 울브스, 리즈}
class Team {
	String team_name;
	int point;
	int[] winning_rate;
	Player best_player;

	public Team(String team_name) {
		this.team_name = team_name;
	}

	@Override
	public String toString() {
		return "Team [team_name=" + team_name + ", point=" + point + ", winning_rate=" + Arrays.toString(winning_rate)
				+ ", best_player=" + best_player + "]";
	}

}

class Player {
	String name;
	int a;
	int d;
	int p;

	public Player(String name, int a, int d, int p) {
		this.name = name;
		this.a = a;
		this.d = d;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Player [선수이름=" + name + ", 공격력=" + a + ", 수비력=" + d + ", 중원장악력=" + p + "]";
	}

}

public class project {
	static List<String> can_winner;

	static String[] team_names = { "맨시티", "맨유", "리버풀", "토트넘", "첼시", "뉴캐슬", "아스날", "QPR", "울브스", "리즈" };

	static String[] players = { "ErlingHaaland 9 5 7", "ChristianoRonaldo 10 3 7", "StevenGerrard 8 7 8",
			"HeungminSon 10 8 8", "FrankLampard 7 8 7", "MiguelAlmiron 7 6 7", "ThierryHenry 9 5 9",
			"JisungPark 8 10 10", "HeechanHwang 9 6 7", "AlanSmith 7 7 7" };

	static int[][] winning_rates = { { -1, 44, 35, 50, 48, 51, 39, 65, 51, 53 },
			{ 56, -1, 53, 63, 59, 67, 53, 85, 59, 65 }, { 65, 47, -1, 63, 55, 70, 53, 81, 61, 69 },
			{ 50, 37, 37, -1, 41, 55, 42, 61, 62, 55 }, { 52, 41, 45, 59, -1, 58, 44, 59, 51, 48 },
			{ 49, 33, 30, 45, 42, -1, 44, 58, 45, 50 }, { 61, 47, 47, 58, 56, 56, -1, 61, 65, 56 },
			{ 35, 15, 19, 39, 41, 42, 39, -1, 46, 45 }, { 49, 41, 39, 38, 49, 55, 35, 54, -1, 45 },
			{ 47, 35, 31, 45, 52, 50, 44, 55, 55, -1 } };

	public static void main(String[] args) {

		Team[] teams = new Team[10];

		for (int i = 0; i < 10; i++) {
			teams[i] = new Team(team_names[i]);
			StringTokenizer st = new StringTokenizer(players[i]);
			teams[i].best_player = new Player(st.nextToken(), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			teams[i].winning_rate = winning_rates[i];
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("우승팀 후보를 보고싶나요? Y / N");
		String yn = scanner.next();
		if (yn.equals("Y")) {
			findChampion(teams);
		}
		while (true) {
			System.out.print("찾고자 하는 Legend가 있나요? Y / N ");
			yn = scanner.next();
			if (yn.equals("Y")) {
				System.out.println("레전드 선수 검색 : ");
				String find_player = scanner.next();
				int cnt = 0;
				for (int i = 0; i < 10; i++) {
					if (kmp(teams[i].best_player.name, find_player)) {
						System.out.println(teams[i].best_player.toString());
						cnt++;
					}
				}
				if (cnt == 0)
					System.out.println("찾고자 하는 선수가 없습니다.");
				System.out.println();
			} else {
				System.out.println("종료");
				break;
			}
		}
		// 팀 정보 출력
//		for (Team t : teams) {
//			System.out.println(t.toString());
//		}

	}

	// 실패함수 getPi()
	public static int[] getPi(String find_player) {
		// 접두사와 접미사가 일치하는 최대길이를 담은 배열
		int[] pi = new int[find_player.length()]; // 0~i까지의 부분 문자열에서 접두사와 접미사 일치하는 길을 담겠다.

		int j = 0; // 현재 여기까지는 같아요~~
		// i, j가 가리키는 값이 같다면 둘다 증가
		// i는 무조건 증가
		for (int i = 1; i < find_player.length(); i++) {
			// 두포인트가 다르다면
			while (j > 0 && find_player.charAt(i) != find_player.charAt(j)) {
				j = pi[j - 1];
			}

			// 두포인트가 같다면
			if (find_player.charAt(i) == find_player.charAt(j))
				pi[i] = ++j; // i번쨰의 최대길이는 ++j값을 저장하겠다.
		}

		return pi;
	}

	public static boolean kmp(String text, String pt) {
		int[] pi = getPi(pt); // 점프테이블 가져와

		int j = 0; // 패턴 내에서 움직이는 인덱스
		// i:본문의 인덱스
		for (int i = 0; i < text.length(); i++) {
			// 실패했다. 점푸
			while (j > 0 && text.charAt(i) != pt.charAt(j))
				j = pi[j - 1];

			// 내가 보고 있는 패턴위치와 텍스트의 값이 동일 하다면
			if (text.charAt(i) == pt.charAt(j)) {
				if (j == pt.length() - 1) {
					// 패턴찾았다.
					return true;
				} else {
					// 다 찾은게 아니라면 계속 진행시켜
					j++;
				}
			}
		}
		return false;
	}

	public static void findChampion(Team[] teams) {
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				double a = Math.random()*100 + teams[i].winning_rate[j];
				double b = Math.random()*100 + teams[j].winning_rate[i];
//				System.out.println(teams[i].team_name + " : " + (int) a + "    "+ teams[j].team_name + " : " + (int) b);
				if (a > b)
					teams[i].point++;
				else if (b > a)
					teams[j].point++;
			}
		}
		int max = 0;
		String winner = "";
		can_winner = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (teams[i].point >= max) {
				max = teams[i].point;
			}
		}
		for (int i = 0; i < 10; i++) {
			if (teams[i].point == max) {
				can_winner.add(teams[i].team_name);
			}
		}
		System.out.println("Champion : " + can_winner + ", Point : " + max);
		System.out.println();
	}
}
