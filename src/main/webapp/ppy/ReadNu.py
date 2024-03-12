import pytesseract
import cv2
import sys


print("오냐?")
ori = cv2.imread("fff/ramyun2.png",cv2.IMREAD_GRAYSCALE)
#ori = cv2.imread("../fff/",cv2.IMREAD_GRAYSCALE)
ori = cv2.resize(ori,dsize=(0,0),fx=1.4, fy=1.4)
ttt = pytesseract.image_to_string(ori,lang='kor+eng')
print(ttt)
