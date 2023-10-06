# 231006_ECAP
박은수 김지환 프로젝트
<ECAP -- EPL Champion Assumption Project>

 

설계한 기능 목록
1.	프리미어리그 상위 10개팀의 상대 승률을 조사해서, 리그전을 통해 승점 계산 후 챔피언을 예측
2.	선수 목록 중 각 선수의 능력치를 임의로 설정하고, KMP 알고리즘을 통해 빠른 선수 검색이 가능
3.	포메이션 배치
4.	DFS로 패스하기 + (가중치 설정을 통해 전술 설정 가능)







참고한 상대전적 사이트
<br>

직접 계산한 EPL팀들의 상대전적 알고리즘.
맨시티 = { -1, 44, 35,50 ,48 ,51 ,39 , 65 , 51 , 53 };
맨유 = { 56, -1, 53 , 63 , 59 ,67 , 53 ,85 ,59 , 65 };
리버풀 = { 65 , 47 , -1 , 63 , 55 , 70 , 53 , 81 ,61 , 69};
토트넘 = {50 ,37 ,37 ,-1 , 41 ,55 , 42 ,61 , 62 , 55};
첼시 = {52 , 41 , 45 , 59 ,-1 ,58 ,44 ,59 ,51 ,48 };
뉴캐슬 = {49 ,33 , 30 ,45 ,42 , -1,44 , 58 ,45 , 50};
아스널 = {61 , 47 , 47 ,58 ,56 ,56 , -1 , 61 ,65 , 56};
QPR = {35 , 15 ,19 , 39 ,41 , 42 , 39 ,-1 ,46 ,45 };
울브스 = { 49 , 41 ,39 , 38 ,49 ,55 ,35 ,54 , -1 ,45 };
리즈 = { 47 ,35 ,31 ,45 ,52 , 50 ,44 ,55 ,55 , -1};

정확한 커리어 및 계산을 통해 계산한 각 팀의 대표선수들과 선수의 능력치
 

알고리즘 적용 기획서
순번	알고리즘	요약
1	우승 후보 팀, 리그전을 통해 선별	반복문 + 정렬 + Math.ranodm 가중치 사용
2	KMP 알고리즘	
3.	DFS를 통한 선수들 패스 진행	11개의 선수 노드를 제작 후 가중치를 통해
4.	포메이션 배치 알고리즘	자리배치 코드를 통해 선수들의 포메이션을 배치할 수 있도록 한다.

Algo-01 . 우승 후보 팀, 리그전을 통해 선별
-	요약

-	상세
프리미어리그 상위 10개팀의 상대 승률을 조사해서, 반복문을 통해 리그전을 실행
승률 + Math.random을 기반으로 승패를 결정. 이후 챔피언을 산출

Algo-02. 축구 팀의 레전드들 이름 검색
-	요약

-	상세
각 팀의 대표 선수의 능력치를 미리 설정해놨고, 사용자가 선수를 입력해서 찾고자 할 때 KMP 알고리즘을 통해 빠른 선수 검색이 가능해진다.
