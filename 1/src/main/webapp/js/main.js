
/////////////////////////////////////////////////////// 메인 슬라이드
// 메인 슬라이드 이동 번호
 let mainSlideIndex = 1;
// 페이지가 시작되면 슬라이드쇼 시작
showMainSlides(mainSlideIndex);

// 현재 번호에서 앞뒤로 움직일 수 있게 함
function plusMainSlides(n) {
  showMainSlides(mainSlideIndex += n);
}

// 메인 슬라이드 쇼에 관한 함수
function showMainSlides(n) {
  mainSlideIndex = n; // 입력된 n을 mainSlideIndex에 저장
  let i; // for문에 필요한 변수
  // 메인 슬라이드(보여줄 화면)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let slides = document.getElementsByClassName("mainSlides");
  // 메인 슬라이드(메뉴 텍스트)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let dots = document.getElementsByClassName("mainDemo");
  // 만약 사이즈가 넘어가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n > slides.length) {mainSlideIndex = 1}
  // 만약 사이즈가 내려가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n < 1) {mainSlideIndex = slides.length}
  
  // 보여줄 화면을 일단 다 꺼둠
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  
  // 메뉴 텍스트를 일단 다 꺼둠
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  
  // 선택된 보여줄 화면과 메뉴 텍스트만 활성화 시킴
  slides[mainSlideIndex-1].style.display = "block"; // 직접 스타일 속성을 넣어서 보이게 만듬
  dots[mainSlideIndex-1].className += " active"; // 클래스 이름을 추가시켜서 css에서 껏다 키게 만듬

}



//////////////////////////////////////////////////////// 중간 슬라이드
// 중간 슬라이드 이동 번호
 let middleSlideIndex = 1;
// 페이지가 시작되면 슬라이드쇼 시작
showMiddleSlides(middleSlideIndex);

// 현재 번호에서 앞뒤로 움직일 수 있게 함
function plusMiddleSlides(n) {
  showMiddleSlides(middleSlideIndex += n);
}

// 중간 슬라이드 쇼에 관한 함수
function showMiddleSlides(n) {
  middleSlideIndex = n; // 입력된 n을 mainSlideIndex에 저장
  let i; // for문에 필요한 변수
  // 중간 슬라이드(보여줄 화면)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let slides = document.getElementsByClassName("tBThumb");
  // 중간 슬라이드(메뉴 텍스트)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let contents = document.getElementsByClassName("tBContent");
  // 만약 사이즈가 넘어가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n > slides.length) {middleSlideIndex = 1}
  // 만약 사이즈가 내려가면 오류가 발생하니 발생하지 않게 넘어가면 1로 전환
  if (n < 1) {middleSlideIndex = slides.length}
  
  // 보여줄 화면을 일단 다 꺼둠
  for (i = 0; i < contents.length; i++) {
    contents[i].style.display = "none";
  }
  
  // 메뉴 텍스트를 일단 다 꺼둠
  for (i = 0; i < slides.length; i++) {
    slides[i].className = slides[i].className.replace(" on", "");
  }
  
  // 선택된 보여줄 화면과 메뉴 텍스트만 활성화 시킴
  contents[middleSlideIndex-1].style.display = "block"; // 직접 스타일 속성을 넣어서 보이게 만듬
  slides[middleSlideIndex-1].className += " on"; // 클래스 이름을 추가시켜서 css에서 껏다 키게 만듬

}

//////////////////////////////////////////////////////// 중간 오른쪽 메뉴

// 중간 오른쪽 메뉴 선택 숫자
 let middleRightSlideIndex = 1;
// 페이지가 시작되면 슬라이드쇼 시작
showMiddleRightSlides(middleRightSlideIndex);

// 중간 슬라이드 쇼에 관한 함수
function showMiddleRightSlides(n) {
  middleRightSlideIndex = n; // 입력된 n을 mainSlideIndex에 저장
  let i; // for문에 필요한 변수
  // 중간 슬라이드(보여줄 화면)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let slides = document.getElementsByClassName("right_sides");
  // 중간 슬라이드(메뉴 텍스트)에 관한 Class들(여러개) 캐싱해서 들고 오기
  let contents = document.getElementsByClassName("right_contents");
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



















