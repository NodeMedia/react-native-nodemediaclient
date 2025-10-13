//
//  RCTNodePublisherView.h
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <React/RCTView.h>

@interface RCTNodePublisherView : UIView

@property (strong, nonatomic) NSString *url;

@property (strong, nonatomic) NSString *cryptoKey;

@property (strong,nonatomic) NSDictionary *audioParam;

@property (strong,nonatomic) NSDictionary *videoParam;

@property (nonatomic) BOOL HWAccelEnable;

@property (nonatomic) BOOL denoiseEnable;

@property (nonatomic) BOOL torchEnable;

@property (nonatomic) BOOL enhancedRtmp;

@property (nonatomic) BOOL frontCamera;

@property (nonatomic) float volume;

@property (nonatomic) float roomRatio;

@property (nonatomic) int cameraDevice;

@property (nonatomic) int keyFrameInterval;

@property (nonatomic) int videoOrientation;



@property (nonatomic, copy) RCTBubblingEventBlock onChange;

-(int)start;

-(int)stop;

-(int)startPreview;

-(int)stopPreview;

@end
