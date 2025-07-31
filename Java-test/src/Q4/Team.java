package Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Team {
    String teamName;
    /* TODO: 올바른 타입의 필드(속성) 선언 변수명은 playerList; */
    List<Player> playerList;

    public Team(String teamName) {
        this.teamName = teamName;
        /* TODO: 위에서 선언한 playerList 필드 초기화 */
        this.playerList = new ArrayList<Player>();
    }

    public void addPlayer(Player player/* TODO: 올바른 매개변수를 선언하세요 */) {
        // TODO: 매개변수로 받은 player 객체를 playerList에 추가하세요.
        this.playerList.add(player);
    }

    public void printPlayerList() {
        // TODO: 반복문을 사용하여 playerList에 있는 모든 선수의 이름을 출력하세요.
        for (Player player : this.playerList) {
            System.out.println(player.name);
        }
    }
}
