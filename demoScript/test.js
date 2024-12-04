function main() {
    home();
    sleep(1500);
    swipe(500,1500,500,300,500);
    sleep(500);
    swipe(500,1500,500,300,500);
    sleep(500);
   var selector = textMatch(".*浏览器.*")
    var result = click(selector);
    if (!result) {
        print("点击失败");
        return;
    }
    // click search view
    var searchBoxSel = idMatch(".*fake_search_box_top.*");
    sleep(1000)
    click(searchBoxSel);
    sleep(3000);
    var searchBoxSel = idMatch(".*search_box.*").getOneNodeInfo();
    searchBoxSel.setText("http://blog.androidcrack.com");
    enter();

}

main();