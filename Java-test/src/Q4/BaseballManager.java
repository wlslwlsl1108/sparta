package Q4;

public class BaseballManager {
    public static void main(String[] args) {
        // 팀 생성
        Team myTeam = new Team("드림팀");

        // 선수 생성 (야구 선수로 변경)
        Player player1 = new Player("오타니");
        Player player2 = new Player("김혜성");

        // 팀에 선수 추가 TODO: Team의 addPlayer 메서드 완성후 아래 주석을 해제해주세요.
        // myTeam.addPlayer(player1);
        // myTeam.addPlayer(player2);

        // 팀 선수 목록 출력
        myTeam.printPlayerList(); // 예상 결과: 오타니, 김혜성 출력
    }
}
