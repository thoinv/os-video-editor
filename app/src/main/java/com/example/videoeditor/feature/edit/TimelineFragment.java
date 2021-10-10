package com.example.videoeditor.feature.edit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.base.viewbinding.BaseFragmentBinding;
import com.example.videoeditor.databinding.FragmentTimelineBinding;
import com.example.videoeditor.entities.Media;
import com.example.videoeditor.feature.recent.RecentCacheData;
import com.quvideo.xiaoying.supertimeline.b.a;
import com.quvideo.xiaoying.supertimeline.b.b;
import com.quvideo.xiaoying.supertimeline.thumbnail.d;
import com.quvideo.xiaoying.supertimeline.thumbnail.g;
import com.quvideo.xiaoying.supertimeline.thumbnail.model.TimeLineBeanData;
import com.quvideo.xiaoying.supertimeline.view.BaseSuperTimeLine;
import com.quvideo.xiaoying.supertimeline.view.SuperTimeLine;
import com.quvideo.xiaoying.supertimeline.view.SuperTimeLineFloat;
import com.quvideo.xiaoying.supertimeline.view.SuperTimeLineGroup;

import java.util.List;

public class TimelineFragment extends BaseFragmentBinding<FragmentTimelineBinding> {
    private SuperTimeLineGroup icR;
    private SuperTimeLine icS;
    private SuperTimeLineFloat juy;

    @Override
    protected void bindViewClickEvent() {

    }

    @Override
    protected void initViews(Bundle bundle) {
        this.icR = binding.timeline;
        this.icS = icR.getSuperTimeLine();
        this.icR.postDelayed(() -> {
            List<Media> selectedItems = RecentCacheData.instance().getSelectedItems();
            int size = selectedItems.size();
            for (int i = 0; i < size; i++) {
                Media media = selectedItems.get(i);
                a aVar = new a();
                aVar.engineId = String.valueOf(media.getMediaResourceId());
                aVar.jjT = 0;
                aVar.length = 2000;
                aVar.jjS = 2000;
                aVar.jkd = 100;
                aVar.filePath = String.valueOf(media.getMediaResourceId());
                b bVar = new b();
                bVar.hCZ = aVar.engineId;
                bVar.leftTime = 0;
                aVar.jkc = a.b.jko;
                icS.getClipApi().b(aVar, true);
            }
        }, 200);

        g.a(new d() {
            /* class com.quvideo.xiaoying.ALiuTestActivity.AnonymousClass1 */

            @Override // com.quvideo.xiaoying.supertimeline.thumbnail.d
            public Bitmap Dj(int i) {
                Log.i("superx", "Dj: " + i);
                return BitmapFactory.decodeResource(getResources(), i);
            }

            @Override // com.quvideo.xiaoying.supertimeline.thumbnail.d
            public Bitmap a(TimeLineBeanData timeLineBeanData, long j) {
                Log.i("superx", "a: filePath=" + timeLineBeanData.filePath);
                return BitmapFactory.decodeResource(getResources(), Integer.parseInt(timeLineBeanData.filePath));
            }

            @Override // com.quvideo.xiaoying.supertimeline.thumbnail.d
            public long b(TimeLineBeanData timeLineBeanData, long j) {
                Log.i("superx", "b: " + j);
                return j;
            }

            @Override // com.quvideo.xiaoying.supertimeline.thumbnail.d
            public Bitmap bNo() {
                Log.i("superx", "bNo: ");
                return null;
            }

            @Override // com.quvideo.xiaoying.supertimeline.thumbnail.d
            public void xU(String str) {
                Log.i("superx", "xU: " + str);
            }
        });

        SuperTimeLineFloat superTimeLineFloat = this.icR.getSuperTimeLineFloat();
        this.juy = superTimeLineFloat;
        superTimeLineFloat.setListener(new SuperTimeLineFloat.a() {
            /* class com.quvideo.xiaoying.ALiuTestActivity.AnonymousClass2 */

            @Override // com.quvideo.xiaoying.supertimeline.view.SuperTimeLineFloat.a
            public void bNj() {
                Toast.makeText(getContext(), "bNj", Toast.LENGTH_SHORT).show();

            }

            @Override // com.quvideo.xiaoying.supertimeline.view.SuperTimeLineFloat.a
            public void bNk() {
                Toast.makeText(getContext(), "bNk", Toast.LENGTH_SHORT).show();

            }

            @Override // com.quvideo.xiaoying.supertimeline.view.SuperTimeLineFloat.a
            public void bNi() {
                Toast.makeText(getContext(), "bNi", Toast.LENGTH_SHORT).show();
                icS.setState(BaseSuperTimeLine.f.jsi);

            }

        });
    }

    @Override
    protected ViewBinding binding() {
        return FragmentTimelineBinding.inflate(getLayoutInflater());
    }
}
