# 小胖自动化助手

> 这是一款基于无障碍开发的自动化工具, 支持Javascript语法编写脚本.
> 


> 感谢FATJS项目提供的思路, 本项目基础架构全抄FatJS.
> 
> API接口参考easyclick 尽可能和easyclick保持一致.



- 免费
- 学习
- 长期维护更新
- 交流/提建议/定制化需求 加微信:cjh-18888


## 文档

### 全局快捷事件
####  点击
##### clickPoint 点击节点
- 点击坐标
- @param x x坐标
- @param y y坐标
- @return {boolean|布尔型}
```javascript
function main() {
    var result = clickPoint(100, 100);
    if (result) {
        toast("点击成功");
    } else {
        toast("点击失败");
    }
}

main();
```

##### click 选择器点击
- 点击选择器
- @param selectors 选择器对象
- @return {boolean|布尔型}
```javascript
function main() {
    var selector = text("我是文本").findOne();
    var result = selector.click();
    if (result) {
        toast("点击成功");
    } else {
        toast("点击失败");
    }
}

main();
```
####  滑动

### 选择器 && 节点

#### text 属性选择
##### 全文本匹配
```javascript
function main() {
    //获取选择器对象
    var selector = text("设置");
    click(selector);
}

main();
```
##### 正则匹配
```javascript
function main() {
    //获取选择器对象
    var selector = textMatch(".*设置.*");
    var result = click(selector);
    if (result) {
        toast("点击成功");
    } else {
        toast("点击失败");
    }
}

main();
```

#### 节点信息类

##### 说明
节点对象NodeInfo，可以通过获取getNodeInfo方法获取到节点信息的数组,节点包含的信息如下
- id: 字符串，资源的ID
- clz: 字符串，视图类名，例如 android.widget.TextView
- pkg: 字符串，包名，例如com.xx
- desc: 字符串，内容描述
- text: 字符串，文本
- checkable: 布尔型，是否可选中
- checked: 布尔型，是否选中
- clickable: 布尔型，是否可点击
- enabled: 布尔型，是否启用
- focusable: 布尔型，是否可获取焦点
- focused: 布尔型，是否聚焦
- longClickable: 布尔型，是否可长点击
- scrollable: 布尔型，是否滚动
- selected: 布尔型，是否被选择
- childCount: 整型，子节点的个数
- index: 整型 节点的索引
- depth: 整型 节点的层级深度
- drawingOrder: 整型 节点的绘制顺序
- bounds: Rect型，空间对象
- - top: 整型，顶部位置
- - bottom: 整型，底部位置
- - left: 整型，左边位置
- - right: 整型，右边位置
- visibleBounds: Rect型，可视空间对象
- - top: 整型，顶部位置
- - bottom: 整型，底部位置
- - left: 整型，左边位置
- - right: 整型，右边位置

##### 选择器获取一个节点 getOneNodeInfo
- 通过选择器 获取第一个节点信息
- @param timeout 等待时间，单位是毫秒, 如果是0，代表不等待
- @return NodeInfo 对象 或者null
```javascript
function main() {
    //获取选择器对象
    //选择 节点 clz=android.widget.CheckBox所有节点，
    var node = clz("android.widget.CheckBox").getOneNodeInfo(10000);

    if (node) {
        var x = node.click();
        logd(x);
    } else {
        toast("无节点");
    }
}

main(); 
```
---
参考项目
- https://github.com/1754048656/FATJS (基本框架 + 大部分基础功能)
- https://ieasyclick.com/ (参考API设计)
- https://github.com/caoccao/Javet (V8引擎)