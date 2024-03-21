import pytesseract
import numpy
import cv2
import sys
from imutils.perspective import four_point_transform

path = sys.argv[1]
#path = "../fff/ramyun5.png"
#ori = cv2.imread(path)
ori = cv2.imread(path)
blur = cv2.GaussianBlur(ori, (7,7), 0)
edged = cv2.Canny(blur,50,200)
ps, hh = cv2.findContours(edged, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
# print(pts)
recPP = None
for pp in ps:
    ## 외각선 단순화
    approx = cv2.approxPolyDP(pp, cv2.arcLength(pp, True) * 0.02, True)

    ## 최초 4각형 : 가장 큰 외곽선 추출 후 리턴
    if len(approx) == 4:
        recPP = approx
        break
recArr = numpy.array([p[0] for p in recPP])
recImg = four_point_transform(ori,recArr)
recImg = cv2.resize(recImg,dsize=(800,860))

pts = [numpy.array([   #kcal
     [[550,70]],
     [[550,130]],
     [[780,130]],
     [[780,70]]
     ])
,
numpy.array([
     [[190, 150]],
     [[190, 210]],
     [[400, 210]],
     [[400, 150]]  # 나트륨
])
,
numpy.array([
     [[220, 230]],
     [[220, 290]],
     [[410, 290]],
     [[410, 230]]  # 탄수화물
])
,
numpy.array([
     [[170, 310]],
     [[170, 370]],
     [[370, 370]],
     [[370, 310]]  # 당류
])
,
numpy.array([
     [[130, 385]],
     [[130, 445]],
     [[330, 445]],
     [[330, 385]]  # 지방
])
,
numpy.array([
     [[300, 470]],
     [[300, 535]],
     [[425, 535]],
     [[425, 470]]  # 트랜스지방
])
,
numpy.array([
     [[250, 550]],
     [[250, 610]],
     [[375, 610]],
     [[375, 550]]  # 포화지방
])
,
numpy.array([
     [[280, 630]],
     [[280, 690]],
     [[450, 690]],
     [[450, 630]]  # 콜레스테롤
])
,
numpy.array([
     [[170, 710]],
     [[170, 770]],
     [[370, 770]],
     [[370, 710]]  # 단백질
])
]
recArr = []

for i, cc in enumerate( pts):

    # 직선 단순화
    points = cv2.approxPolyDP(cc, cv2.arcLength(cc,True) * 0.02, True)
    lowX = points[0][0][0]
    lowY = points[0][0][1]
    highX = points[0][0][0]
    highY = points[0][0][1]
    for ppp in points:
        pp = ppp[0]
        if lowX > pp[0]:
            lowX = pp[0]
        if highX < pp[0]:
            highX = pp[0]
        if lowY > pp[1]:
            lowY = pp[1]
        if highY < pp[1]:
            highY = pp[1]

    #print(len(points), lowX,lowY, highX, highY)

    rectangle = recImg[lowY:highY, lowX:highX].copy()
    ttt = pytesseract.image_to_string(rectangle, lang='kor+eng')
    try:
        a = int(ttt[:-1].split(' ')[0])
        if(ttt[-2:-1]=="8" and len(ttt[:-1].split(' '))!=2):
            print(ttt[:-2]+" "+"g")
        elif(len(ttt[:-1].split(' '))!=2):
            print("err")
        else:
            print(ttt[:-1])
    except ValueError:
        print("ValueErr")