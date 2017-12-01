package com.example.qqdemo.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class SlideListView extends ListView{

    private SlideItem mTouchView=null;//��¼��ǰ�����item View
    private float mDownX;//x������
    private float mDownY;//y������
    private int mTouchState;//��¼���״̬
    private int mTouchPosition;//��¼���λ��
    private static final int TOUCH_STATE_NONE=0; //����״̬
    private static final int TOUCH_STATE_X=1;//�Ử״̬
    private static final int TOUCH_STATE_Y=2;//����״̬
    //�жϺ�����������Сֵ
    private static final int MAX_Y=5;
    private static final int MAX_X=3;

    public SlideListView(Context context) {
        super(context);
    }

    public SlideListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() != MotionEvent.ACTION_DOWN && mTouchView == null)
            return super.onTouchEvent(ev);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //��ס��item��position
                int oldPosition = mTouchPosition;
                //��¼λ��
                mDownX = ev.getX();
                mDownY = ev.getY();
                mTouchState = TOUCH_STATE_NONE;
                //���ݵ�ǰ����������ȡ�����item��position
                mTouchPosition = this.pointToPosition((int) ev.getX(), (int) ev.getY());

                //�жϵ�ǰ������Ƿ���ϴε����item��ͬһ���������ͬһ��������״̬�Ǵ��˵ľͼ�¼״̬������
                //��¼����ͨ��Item�е�downX����
                if (mTouchPosition == oldPosition && mTouchView != null && mTouchView.isOpen()) {
                    mTouchState = TOUCH_STATE_X;
                    mTouchView.onSwipe(ev);
                    return true;
                }
                //��ȡ��ǰ��item��View
                View currentView = getChildAt(mTouchPosition - getFirstVisiblePosition());
                //�������ͬһ��item ��ô����Ļ��͹رյ�֮ǰ�򿪵�item
                if (mTouchView != null && mTouchView.isOpen()) {
                    mTouchView.smoothCloseMenu();
                    mTouchView = null;
                    return super.onTouchEvent(ev);
                }
                //�жϸ�view������
                if (currentView instanceof SlideItem) {
                    mTouchView = (SlideItem) currentView;
                }
                if (mTouchView != null) {
                    mTouchView.onSwipe(ev);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                float dy = Math.abs((ev.getY() - mDownY));
                float dx = Math.abs((ev.getX() - mDownX));
                if (mTouchState == TOUCH_STATE_X) {
                    if (mTouchView != null) {
                        //ִ�л���
                        mTouchView.onSwipe(ev);
                    }
                    return true;
                } else if (mTouchState == TOUCH_STATE_NONE) {
                    //�жϻ�������x����ִ�л�����Y����ִ�й���
                    if (Math.abs(dy) > MAX_Y) {
                        mTouchState = TOUCH_STATE_Y;
                    } else if (dx > MAX_X) {
                        mTouchState = TOUCH_STATE_X;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //�ж�״̬
                if (mTouchState == TOUCH_STATE_X) {
                    if (mTouchView != null) {
                        mTouchView.onSwipe(ev);
                        //������״̬�Ǵ� ��ô�����³�ʼ��
                        if (!mTouchView.isOpen()) {
                            mTouchPosition = -1;
                            mTouchView = null;
                        }
                    }
                    ev.setAction(MotionEvent.ACTION_CANCEL);
                    super.onTouchEvent(ev);
                    return true;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }
}
