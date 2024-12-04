//-------------------- pre set -------------------//
let task = new engines();
const getHashMapBuffer = () => {
    let buffer = task._getHashMapBuffer();
    if(buffer != null) {
        return buffer;
    }
    return null;
}
// -------------------- 全局快捷事件-------------------//
//  ---- 选择器 ----//
const text = (str) => task._text(str);

//  ---- 点击事件 ----//
const click = (node) => task._clickNode(node);
const clickPoint = (x, y) => task._clickPoint(x, y);
//  ---- 滑动事件 ----//
const swipe = (x1, y1, x2, y2, duration) => task._swipe(x1, y1, x2, y2, duration);

// -------------------- 日志输出类 -------------------//
const print = (msg) => task._print(msg + '');
const showLog = () => task._showLog();
const hideLog = () => task._hideLog();
const fullScreenLog = () => task._fullScreenLog();
const clearLog = () => task._clearLog();
// -------------------- 基础类 -------------------//
const home = () => task._home();
const back = () => task._back();

// -------------------- 时间类 -------------------//
const sleep = (ms) => task._sleep(ms);

// -------------------- 网络请求类 -------------------//

// -------------------- 工具类 -------------------//

//-------------------- pre end -------------------//