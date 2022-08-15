 /////////////////////////////////////////////////////// 메인 슬라이드
// 사이드 슬라이드 이동 번호
 let sideSlideIndex = 1;
// 페이지가 시작되면 슬라이드쇼 시작
showSideSlides(sideSlideIndex);

// 사이드 슬라이드 쇼에 관한 함수
function showSideSlides(n) {
  sideSlideIndex = n; // 입력된 n을 mainSlideIndex에 저장
  let i; // for문에 필요한 변수
  // 사이드 슬라이드(보여줄 화면)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let slides = document.getElementsByClassName("remote_product");
  
  // 만약 사이즈가 넘어가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n > slides.length) {sideSlideIndex = 1}
  // 만약 사이즈가 내려가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n < 1) {sideSlideIndex = slides.length}
  
  // 보여줄 화면을 일단 다 꺼둠
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  
  // 선택된 보여줄 화면과 메뉴 텍스트만 활성화 시킴
  slides[sideSlideIndex-1].style.display = "block"; // 직접 스타일 속성을 넣어서 보이게 만듬
}












