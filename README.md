# 231006_ECAP
박은수 김지환 프로젝트
<ECAP -- EPL Champion Assumption Project>

![EPL](https://github.com/KimJihwan98/231006_ECAP/assets/81845773/f6622a05-6433-4e58-8425-e851fd794d36)

설계한 기능 목록
1.	프리미어리그 상위 10개팀의 상대 승률을 조사해서, 리그전을 통해 승점 계산 후 챔피언을 예측
2.	선수 목록 중 각 선수의 능력치를 임의로 설정하고, KMP 알고리즘을 통해 빠른 선수 검색이 가능
3.	포메이션 배치
4.	DFS로 패스하기 + (가중치 설정을 통해 전술 설정 가능)

참고한 상대전적 사이트

![제목 없음](https://github.com/KimJihwan98/231006_ECAP/assets/81845773/37679073-9196-43a4-9f1a-2152710d4c99)

직접 계산한 EPL팀들의 상대전적 알고리즘.

![EPL_Background_Spotlight_Logos](https://github.com/KimJihwan98/231006_ECAP/assets/81845773/27740b23-4af8-4fb6-a23d-691cede03506)
<br/>
맨시티 = { -1, 44, 35,50 ,48 ,51 ,39 , 65 , 51 , 53 }; <br/>
맨유 = { 56, -1, 53 , 63 , 59 ,67 , 53 ,85 ,59 , 65 }; <br/>
리버풀 = { 65 , 47 , -1 , 63 , 55 , 70 , 53 , 81 ,61 , 69}; <br/>
토트넘 = {50 ,37 ,37 ,-1 , 41 ,55 , 42 ,61 , 62 , 55}; <br/>
첼시 = {52 , 41 , 45 , 59 ,-1 ,58 ,44 ,59 ,51 ,48 }; <br/>
뉴캐슬 = {49 ,33 , 30 ,45 ,42 , -1,44 , 58 ,45 , 50}; <br/>
아스널 = {61 , 47 , 47 ,58 ,56 ,56 , -1 , 61 ,65 , 56}; <br/>
QPR = {35 , 15 ,19 , 39 ,41 , 42 , 39 ,-1 ,46 ,45 }; <br/>
울브스 = { 49 , 41 ,39 , 38 ,49 ,55 ,35 ,54 , -1 ,45 }; <br/>
리즈 = { 47 ,35 ,31 ,45 ,52 , 50 ,44 ,55 ,55 , -1}; <br/>

정확한 커리어 및 계산을 통해 계산한 각 팀의 대표선수들과 선수의 능력치

![1234124](https://github.com/KimJihwan98/231006_ECAP/assets/81845773/a599b8e6-54ec-4bb8-8668-2018bb9a875c)

알고리즘 적용 기획서

![123](https://github.com/KimJihwan98/231006_ECAP/assets/81845773/3910432c-8e62-44a8-87f0-29f26b151949)

Algo-01 . 우승 후보 팀, 리그전을 통해 선별
-	요약
반복문 , 정렬, Math.random()을 사용하여 팀별 승률에 기반한 가중치를 더하여 승/패를 결정
-	상세
프리미어리그 상위 10개팀의 상대 승률을 조사해서, 반복문을 통해 리그전을 실행. 승률 + Math.random을 기반으로 승패를 결정. 이후 챔피언을 산출
-	이점 
계속해서 다양한 팀이 우승후보로 선발되는 과정을 지켜볼 수 있다. 초기에는 Data를 직접 입력했는데, 이 과정에서 DB의 필요성을 느끼게 되었다. 또한 축구를 좋아한다면 재밌을 것.
-	이슈사항
-	초기에 설계 실수로 Math.random()의 가중치를 승률에 곱해버려서, 우승 확률이 낮은팀들도 상대 승률이 아닌 랜덤값에 따라 우승 후보로 선발되게 되었다. 프로그램을 제작한 후에 테스트해볼 때 이상함을 느끼고, 가중치를 곱하는 것이 아닌 더하는 방식으로 재설계함.


Algo-02. 축구 팀의 레전드들 이름 검색
-	요약
KMP 알고리즘 사용
-	상세
각 팀의 대표 선수의 능력치를 미리 설정해놨고, 사용자가 선수를 입력해서 찾고자 할 때 KMP 알고리즘을 통해 빠른 선수 검색이 가능해진다.
-	이점
무한대의 길이에 가까운 축구선수들의 이름이 존재한다면, 기존의 Brutal Force 보다 이름 검색을 더 빠르게 할 수 있었다.
-	이슈사항
없음.

Algo-03. DFS를 통한 선수들 패스 경로 탐색
-	요약
11개의 선수 노드를 제작 후, 가중치를 통해 패스가 진행되는 10번의 경우 탐색
-	상세
1부터 11까지의 인덱스를 기반으로, 11명의 패스 전개 로드맵을 파악할 수 있도록 한다. DFS 알고리즘을 통해 순회하고자 했음.
-	이점
실제 축구 경기의 패스 전개를 상상할 수 있음. 게임을 하는 것과 비슷한 느낌 ㅎ
-	이슈사항
없음. (시간 부족으로 인해 구현하지 않음.)

Algo-04. 포메이션 배치 알고리즘
-	요약
자리 배치 코드를 통해 선수들의 포메이션을 배치할 수 있도록 한다.
-	상세
교수님이 제공해주신 Open Soure를 활용하여 프론트 상에 배치된 11개의 포메이션 공석들 중 선수를 배치할 수 있도록 한다.
-	이점
재밌다.
-	이슈 사항
1)	무작위로 선수가 뽑히기 때문에, 선수들의 포지션과는 상관없이 선발되는 경우가 생김
2)	시간 부족 + 스프링에 대한 이해도 부족으로 프론트 화면 제작에 실패해서 매우 아쉬웠음.


Copyright By JiHwan Kim, EunSoo Park
