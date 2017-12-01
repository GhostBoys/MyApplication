package com.example.qqdemo.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class SlideItem extends LinearLayout {
    private View contentView = null; //��������ʾ��view
    private View menuView = null; //����ʾ��view

    //���㻬�� ����Ч��
    private Scroller mOpenScroller;
    private Scroller mCloseScroller;

    private int downX; //��ʼ���µ�λ��

    //��¼״̬
    private int state = STATE_CLOSE;
    private static final int STATE_CLOSE = 0;
    private static final int STATE_OPEN = 1;

    private int mBaseX;//�ڹرջ�����ʱ������븸���ֵ�ʣ�����


    public SlideItem(Context context) {
        super(context);
    }

    public SlideItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setContentView(View contentView, View rightView){

        this.contentView = contentView;
        this.menuView = rightView;

        //��ʼ��mColoseScroller��mOpenScroller
        mCloseScroller=new Scroller(getContext());
        mOpenScroller = new Scroller(getContext());

        initView();
    }
    //child view�Ĳ��ֲ����趨�ú� ��ӵ�parent view����
    private void initView() {
        //�������ÿ�͸�
        LayoutParams contentParams = new LayoutParams
                (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        LayoutParams rightParams=new LayoutParams
                (LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(contentParams);
        contentView.setPadding(10,10,10,10);
        menuView.setLayoutParams(rightParams);
        this.addView(contentView);
        this.addView(menuView);
    }

    // �ж��Ƿ񻬳���״̬
    public boolean isOpen() {
        return state == STATE_OPEN;
    }

    /**
     * ��listView���� ������ͼ���ƶ�   listView�ж�״̬ ʲô�������
     * @param event
     * @return
     */
    public boolean onSwipe(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                //����λ�ü�ȥ�ƶ�λ�� ��ȡ�ƶ��ľ���
                int dis = (int) (downX - event.getX());
                if (state == STATE_OPEN) {
                    dis += menuView.getWidth();
                }
                //�ƶ�
                move(dis);
                break;
            case MotionEvent.ACTION_UP:
                //�������ұ���ͼһ��ľ��� �Զ���������
                if ((downX - event.getX()) > (menuView.getWidth() / 2)) {
                    smoothOpenMenu();
                } else {
                    smoothCloseMenu();
                    return false;
                }
                break;
        }
        //���ѵ��¼�
        return true;
    }

    /**
     * ��ͼ���»���ʱ����
     */
    @Override
    public void computeScroll() {
        if (state == STATE_OPEN) {
            //computeScrollOffset�����Ƿ����
            if (mOpenScroller.computeScrollOffset()) {
                move(mOpenScroller.getCurrX());
                postInvalidate();
            }
        } else {
            if (mCloseScroller.computeScrollOffset()) {
                move(mBaseX - mCloseScroller.getCurrX());
                postInvalidate();
            }
        }
    }

    /**
     * �ƶ���ͼ
     * @param dis
     */
    private void move(int dis) {
        //�������ж���Ϊ�˱�֤ ��Ҫ����ͼ�ƶ����� ������ͼƫ��
        if (dis > menuView.getWidth()) {
            dis = menuView.getWidth();
        }
        if (dis < 0) {
            dis = 0;
        }
        //view.layout()����view������丸���ֵ�λ��   �ڴ����ƶ���ʱ����ò��ϸı�λ�� ���ʵ�ʵĻ���Ч��
        contentView.layout(-dis, contentView.getTop(), contentView.getWidth() - dis, getMeasuredHeight());
        menuView.layout(contentView.getWidth() - dis, menuView.getTop(), contentView.getWidth() + menuView.getWidth() - dis, menuView.getBottom());
    }

    /**
     * �����ر�
     * contentView.getLeft()  ���丸��ͼ�����λ��
     */
    public void smoothCloseMenu() {
        state = STATE_CLOSE;
        mBaseX = -contentView.getLeft();
        mCloseScroller.startScroll(0, 0, mBaseX, 0, 350);
        postInvalidate();
    }

    /**
     * ������
     */
    public void smoothOpenMenu() {
        state = STATE_OPEN;
        mOpenScroller.startScroll(-contentView.getLeft(), 0, menuView.getWidth(), 0, 350);
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(menuView != null)
            menuView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY));
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //ȷ��centerView menuView����ʾλ��
        if(contentView != null)
            contentView.layout(0, 0, getMeasuredWidth(), contentView.getMeasuredHeight());
        if(menuView != null)
            menuView.layout(getMeasuredWidth(), 0, getMeasuredWidth() + menuView.getMeasuredWidth(), contentView.getMeasuredHeight());
    }
}