function fileTest(){

 var data = file.readFile("/sdcard/test.txt");
 print(data);
     let r = file.deleteLine("/sdcard/test.txt", -1, "22222");
     print(r)
var data = file.readFile("/sdcard/test.txt");
 print(data);
file.create("/sdcard/asdddddd")
file.create("/sdcard/asddddddir/")

print(file.readAssets("base.js"))
print("deleteAllFile:" + file.deleteAllFile("/sdcard/asddddddir"))
}


fileTest();