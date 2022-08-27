/**
 * 
 */
 let login_form_index=1;
 
 showLoginFormSlides(1);
 
 function showLoginFormSlides(n) {
  middleRightSlideIndex = n; // 입력된 n을 mainSlideIndex에 저장
  let i; // for문에 필요한 변수
  // 중간 슬라이드(보여줄 화면)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let slides = document.getElementsByClassName("login_sides");
  // 중간 슬라이드(메뉴 텍스트)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let contents = document.getElementsByClassName("login_contents");
  // 만약 사이즈가 넘어가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
//  if (n > slides.length) {middleSlideIndex = 1}
  // 만약 사이즈가 내려가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
//  if (n < 1) {middleSlideIndex = slides.length}
  
  // 보여줄 화면을 일단 다 꺼둠
  for (i = 0; i < contents.length; i++) {
    contents[i].style.display = "none";
  }
  
  // 메뉴 텍스트를 일단 다 꺼둠
  for (i = 0; i < slides.length; i++) {
    slides[i].className = slides[i].className.replace(" on", "");
  }
  
  // 선택된 보여줄 화면과 메뉴 텍스트만 활성화 시킴
  contents[middleRightSlideIndex-1].style.display = "block"; // 직접 스타일 속성을 넣어서 보이게 만듬
  slides[middleRightSlideIndex-1].className += " on"; // 클래스 이름을 추가시켜서 css에서 껏다 키게 만듬

}
